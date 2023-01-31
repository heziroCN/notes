package haiwaitu.t20211112;

/**
 * @Author huangjunqiao
 * @Date 2021/11/13 15:56
 * @Description 375. 猜数字大小 II
 */
public class GetMoneyAmount {
    public int getMoneyAmount(int n) {
        // 时间：O(N^3)，空间：O(N^2)
        int[][] dp = new int[n + 1][n + 1];
        for (int l = n - 1; l > 0; l--) {
            for (int r = l + 1; r <= n; r++) {
                // 计算[l,r]内猜到任意数字需要的最小现金
                int minCost = Integer.MAX_VALUE;
                for (int guess = l; guess < r; guess++) {
                    int cost = guess + Math.max(dp[l][guess - 1], dp[guess + 1][r]);
                    minCost = Math.min(minCost, cost);
                }
                dp[l][r] = minCost;
            }
        }
        return dp[1][n];
    }
}
