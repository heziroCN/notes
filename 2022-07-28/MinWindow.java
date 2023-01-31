package haiwaitu.t20220728;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangjunqiao
 * @Date 2022/07/28 02:14
 * @Description 76. 最小覆盖子串
 */
public class MinWindow {

    Map<Character, Integer> tCnt = new HashMap<>(), wdCnt = new HashMap<>();
    public String minWindow(String s, String t) {
        // 时间：O(C*s+t)，空间：O(C)，C为字符集大小
        for (char c : t.toCharArray()) {
            tCnt.put(c, tCnt.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0;
        int len = Integer.MAX_VALUE, sLen = s.length();;
        int start = 0, end = -1;
        while (r < sLen) {
            if (tCnt.containsKey(s.charAt(r))) {
                wdCnt.put(s.charAt(r), wdCnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (valid() && l <= r) {
                if (r - l + 1 < len) {
                    start = l;
                    end = r;
                    len = r - l + 1;
                }
                wdCnt.put(s.charAt(l), wdCnt.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
            r++;
        }
        return s.substring(start, end + 1);
    }
    public boolean valid() {
        for (Map.Entry<Character, Integer> entry : tCnt.entrySet()) {
            char c = entry.getKey();
            if (!wdCnt.containsKey(c) || wdCnt.get(c) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
