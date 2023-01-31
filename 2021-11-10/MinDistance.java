package haiwaitu.t20211110;

/**
 * @Author huangjunqiao
 * @Date 2021/11/10 16:13
 * @Description 72. 编辑距离
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        // 动态规划，时间：O(MN)，空间：O(MN)
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];//表示word1前i个字符和word2前j个字符的编辑距离，dp[i][j]可以三个状态转移得到，dp[i-1][j]+1，dp[i][j-1]+1或者dp[i-1][j-1]+1（如果word1的第i个字符等于word2的第j个字符，则不需要+1）
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }
        String s = word1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int left = dp[i][j - 1] + 1, up = dp[i - 1][j] + 1;
                int leftUp = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    leftUp++;
                }
                dp[i][j] = Math.min(leftUp, Math.min(left, up));
            }
        }
        return dp[m][n];
    }
}
