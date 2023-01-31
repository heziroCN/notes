package haiwaitu.t20220128;

/**
 * @Author huangjunqiao
 * @Date 2022/01/28 23:26
 * @Description 395. 至少有 K 个重复字符的最长子串
 */
public class LongestSubstring {
     public int longestSubstring(String s, int k) {
         // 滑动窗口，按字符种类分别统计子串长度，时间：O(ns+s^2)，空间：O(s)，s为字符集大小，用时：没思路，参考官解实现
         int res = 0;
         int n = s.length();
         for (int t = 1; t <= 26; t++) {
             int[] freq = new int[26];
             int l = 0, r = 0;
             int less = 0, total = 0;
             while (r < n) {
                 char cr = s.charAt(r);
                 freq[cr - 'a']++;
                 if (freq[cr - 'a'] == 1) {
                     total++;
                     less++;
                 }
                 if (freq[cr - 'a'] == k) {
                     less--;
                 }
                 while (total > t) {
                     char cl = s.charAt(l);
                     freq[cl - 'a']--;
                     if (freq[cl - 'a'] == 0) {
                         total--;
                         less--;
                     }
                     if (freq[cl - 'a'] == k - 1) {
                         less++;
                     }
                     l++;
                 }
                 if (less == 0) {
                     res = Math.max(res, r - l + 1);
                 }
                 r++;
             }
         }
         return res;
     }

    public int longestSubstring0(String s, int k) {
        return dfs(s, k, 0, s.length() - 1);
    }
    public int dfs(String s, int k, int l, int r) {
        // 分治，时间：O(ns)，空间：O(s^2)，s为字符集大小
        int[] freq = new int[26];
        for (int i = l; i <= r; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0 && freq[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) {
            return r - l + 1;
        }
        int res = 0;
        int idx = l;
        while (idx <= r) {
            while (idx <= r && s.charAt(idx) == split) {
                idx++;
            }
            if (idx > r) {
                break;
            }
            int start = idx;
            while (idx <= r && s.charAt(idx) != split) {
                idx++;
            }
            int currLen = dfs(s, k, start, idx - 1);
            res = Math.max(res, currLen);
        }
        return res;
    }
}
