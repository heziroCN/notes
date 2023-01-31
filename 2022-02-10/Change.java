package haiwaitu.t20220210;

/**
 * @Author huangjunqiao
 * @Date 2022/02/11 16:49
 * @Description 518. 零钱兑换 II
 */
public class Change {
    public int change(int amount, int[] coins) {
        // dp，时间：O(n)，空间：O(n)
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
