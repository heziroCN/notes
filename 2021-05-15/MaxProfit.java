package haiwaitu.t20210515;

/**
 * @Author huangjunqiao
 * @Date 2021/05/16 23:26
 * @Description 卖股票的最佳时机 II
 */
public class MaxProfit {
    public int maxProfit0(int[] prices) {
        // 动态规划解法，dp[i][0]表示第i天没股票利润，dp[i][1]表示第i天持有股票的利润。可得状态转移方程dp[n][0]=max{dp[n-1][0],dp[n-1][1] + prices[n]},
        // dp[n][1]=max{dp[n-1][1], dp[n-1][0]-prices[n]}
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public int maxProfit(int[] prices) {
        // 贪心解法，找到数组内的所有上升区间，累加即可
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += prices[i] - prices[i - 1] > 0 ? prices[i] - prices[i - 1] : 0;
        }
        return result;
    }
}
