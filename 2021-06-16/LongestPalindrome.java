package haiwaitu.t20210616;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangjunqiao
 * @Date 2021/06/17 11:02
 * @Description 409. 最长回文串
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        // 基于哈希表的贪心，时间O(N)，空间O(S)，S为字符集大小
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, 1 + map.getOrDefault(c, 0));
        }
        // 多少对相同的字符
        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int cNum = entry.getValue();
            count += (cNum >> 1);
        }
        count <<= 1;
        return count < s.length() ? count + 1 : count;
    }


     public int longestPalindrome0(String s) {
         // 基于数组的贪心，时间O(N)，空间O(S)，S为字符集大小
         int[] count = new int[128];
         for (int i = 0; i < s.length(); i++) {
             count[s.charAt(i)]++;
         }
         int ans = 0;
         for (int num : count) {
             ans += (num >> 1);
         }
         ans <<= 1;
         return ans < s.length() ? ans + 1 : ans;
     }
}
