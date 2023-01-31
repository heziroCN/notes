package haiwaitu.t20220516;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangjunqiao
 * @Date 2022/05/16 16:57
 * @Description 13. 罗马数字转整数
 */
public class RomantoInt {
    public int romanToInt(String s) {
        // 时间：O(n)，空间：O(S)，S为字符集大小。
        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int num = map.get(s.charAt(i));
            if (i < n - 1 && num < map.get(s.charAt(i + 1))) {
                res -= num;
            } else {
                res += num;
            }
        }
        return res;
    }
}
