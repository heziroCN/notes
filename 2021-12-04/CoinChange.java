package haiwaitu.t20211204;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author huangjunqiao
 * @Date 2021/12/05 20:18
 * @Description 322. 零钱兑换
 */
public class CoinChange {
    // public int coinChange(int[] coins, int amount) {
    //     // 动态规划，时间：O(MN)，空间：O(M)，M为金额大小，N为硬币种类
    //     int[] dp = new int[amount + 1];// dp[money]表示组成money最少需要的硬币个数
    //     Arrays.fill(dp, amount + 1);
    //     dp[0] = 0;

    //     int len = coins.length;
    //     for (int i = 1; i < amount + 1; i++) {
    //         for (int j = 0; j < len; j++) {
    //             if (i >= coins[j]) {
    //                 dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
    //             }
    //         }
    //     }
    //     return dp[amount] > amount ? -1 : dp[amount];
    // }

    public int coinChange(int[] coins, int amount) {
        // BFS，时间：O(N^M)，空间：O(N^M)，M为金额大小，N为硬币种类
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});

        int INF = amount + 1;
        int min = INF;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int sum = curr[0], coinNum = curr[1];
            if (sum > amount) {
                continue;
            } else if (sum == amount) {
                min = Math.min(min, coinNum);
            } else {
                for (int coin : coins) {
                    q.offer(new int[] {sum + coin, coinNum + 1});
                }
            }
        }
        return min == INF ? -1 : min;
    }
}
