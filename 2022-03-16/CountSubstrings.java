package haiwaitu.t20220316;

/**
 * @Author huangjunqiao
 * @Date 2022/03/16 18:39
 * @Description 647. 回文子串
 */
public class CountSubstrings {
     public int countSubstrings(String s) {
         // 时间：O(n^2)，空间：O(1)
         int n = s.length();
         int res = 0;
         for (int i = 0; i < n; i++) {
             res += count(s, n, i, i);
             res += count(s, n, i, i + 1);
         }
         return res;
     }
     public int count(String s, int n, int left, int right) {
         int sum = 0;
         while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
             left--;
             right++;
             sum++;
         }
         return sum;
     }

    public int countSubstrings0(String s) {
        // dp，时间：O(n^2)，空间：O(n^2)
        int n = s.length(), res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
