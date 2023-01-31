package haiwaitu.t20220208;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author huangjunqiao
 * @Date 2022/02/09 00:12
 * @Description 187. 重复的DNA序列
 */
public class FindRepeatedDnaSequences {
     public List<String> findRepeatedDnaSequences(String s) {
         // 哈希表，时间：O(NL)，空间：O(NL)，L为子串长度（10）。用时：11min
         int n = s.length();
         Map<String, Integer> map = new HashMap<>();
         List<String> res = new ArrayList<>();
         for (int i = 0; i <= n - 10; i++) {
             String subStr = s.substring(i, i + 10);
             map.put(subStr, map.getOrDefault(subStr, 0) + 1);
             if (map.get(subStr) == 2) {
                 res.add(subStr);
             }
         }
         return res;
     }

    Map<Character, Integer> bin = new HashMap<>() {{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }};
    static final int L = 10;
    public List<String> findRepeatedDnaSequences0(String s) {
        // 用两个比特表示4个字符，位运算+滑动窗口，时间：O(n)，空间：O(n)
        int n = s.length();
        List<String> res = new ArrayList<>();
        if (n <= L) {
            return res;
        }
        int x = initx(s);
        Map<Integer, Integer> cnt = new HashMap<>();

        for (int i = 0; i <= n - L; i++) {
            x = (x << 2) | bin.get(s.charAt(i + L - 1));
            x &= (1 << (L * 2)) - 1;
            cnt.put(x, 1 + cnt.getOrDefault(x, 0));
            if (cnt.get(x) == 2) {
                res.add(s.substring(i, i + L));
            }
        }
        return res;
    }
    public int initx(String s) {
        int x = 0;
        for (int i = 0; i < L - 1; i++) {
            x = (x << 2) | bin.get(s.charAt(i));
        }
        return x;
    }
}
