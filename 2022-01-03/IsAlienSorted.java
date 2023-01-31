package haiwaitu.t20220103;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangjunqiao
 * @Date 2022/01/04 21:20
 * @Description 953. 验证外星语词典
 */
public class IsAlienSorted {
    Map<Character, Integer> map;
    public boolean isAlienSorted(String[] words, String order) {
        // 时间：O(MN)，空间：O(S)，M为字符串数量，N为字符串长度。
        map = new HashMap<>();
        int len1 = words.length, len2 = order.length();
        for (int i = 0; i < len2; i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < len1; i++) {
            if (!isOrder(words[i - 1], words[i])) {
                return false;
            }
        }
        return true;
    }
    public boolean isOrder(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        for (int i = 0; i < len1 && i < len2; i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (map.get(c1) > map.get(c2)) {
                return false;
            } else if (map.get(c1) < map.get(c2)) {
                return true;
            }
        }
        if (len1 > len2) {
            return false;
        }
        return true;
    }
}
