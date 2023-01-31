package haiwaitu.t20210503;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/05/04 02:15
 * @Description 3. 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {

    /**
     * 动态规划（比HashMap优化的滑动时间窗时间性能好一倍，空间一样）
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        boolean isAllSpace = true;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isWhitespace(s.charAt(i))) {
                isAllSpace = false;
            }
        }
        if (isAllSpace) {
            return 1;
        }

        int[] position = new int[128];
        for (int i = 0; i < position.length; i++) {
            position[i] = -1;
        }

        int maxLen = 0;
        int curLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int prevIndex = position[s.charAt(i)];
            if (prevIndex < 0 || i - prevIndex > curLen) {
                curLen++;
            } else {
                if (curLen > maxLen) {
                    maxLen = curLen;
                }
                curLen = i - prevIndex;
            }

            position[s.charAt(i)] = i;
        }

        if (curLen > maxLen) {
            maxLen = curLen;
        }

        return maxLen;
    }

    /**
     * 数组和ascii码优化的滑动时间窗（目前最优）
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int ans = 0;

        int[] index = new int[128];
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
