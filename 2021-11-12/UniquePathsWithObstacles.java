package haiwaitu.t20211112;

/**
 * @Author huangjunqiao
 * @Date 2021/11/13 16:16
 * @Description 63. 不同路径 II
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 时间：O(MN)，空间：O(N)，用时：15min
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];// 滚动数组，记录上一行的路径
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n - 1];
    }
}
