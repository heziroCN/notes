package zlt20220126;

/**
 * @Author heziro
 * @Date 2022/01/26 17:00
 * @Description 664. 奇怪的打印机
 */
public class StrangePrinter {
    public int strangePrinter(String s) {
        // dp，时间：O(n^3)，空间：O(n^2)
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
