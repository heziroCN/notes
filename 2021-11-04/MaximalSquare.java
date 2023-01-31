package haiwaitu.t20211104;

/**
 * @Author huangjunqiao
 * @Date 2021/11/05 21:53
 * @Description 221. 最大正方形
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        // 动态规划，时间：O(MN)，空间：O(MN)
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int side = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                    side = Math.max(side, dp[i][j]);
                }
            }
        }
        return side * side;
    }
}
