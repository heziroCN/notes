package haiwaitu.t20220201;

/**
 * @Author huangjunqiao
 * @Date 2022/02/03 17:15
 * @Description 1049. 最后一块石头的重量 II
 */
public class LastStoneWeight {
    public int lastStoneWeightII(int[] stones) {
        // 将问题转化为0/1背包问题，求令 sum-2neg 最小的最大neg，时间：O(nsum)，空间：O(sum)
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int n = stones.length;
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;// 使i=0时，dp[0][stones[0]]得到正确的结果
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= stones[i]) {
                    dp[i + 1][j] = dp[i][j - stones[i]] || dp[i][j];
                } else {
                    dp[i + 1][j] = dp[i][j];
                }
            }
        }
        for (int j = target;; j--) {
            if (dp[n][j]) {
                return sum - 2 * j;
            }
        }
    }
}
