package haiwaitu.t20211014;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2021/10/15 01:23
 * @Description 787. K 站中转内最便宜的航班
 */
public class FindCheapestFlight {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 动态规划，f(t*i)=f((t-1)j) + cost，t表示当前转机的第t个航班，cost表示从j飞到i的花费。则第t轮可以根据(t-1)轮的结果，计算并更新飞到目的地i的最小花费。
        // 时间：O((n+N)k)，N为数组长度，空间：O(kn)
        int INF = 10000 * 100 + 1;//至多100个航班，每张票最贵10000
        int len = flights.length;
        int[][] f = new int[k + 2][n];
        for (int i = 0; i < k + 2; i++) {
            Arrays.fill(f[i], INF);
        }
        f[0][src] = 0;
        for (int t = 1; t < k + 2; t++) {
            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], cost = flight[2];
                f[t][to] = Math.min(f[t][to], f[t - 1][from] + cost);
            }
        }
        int res = Integer.MAX_VALUE;
        for (int t = 1; t < k + 2; t++) {
            res = Math.min(res, f[t][dst]);
        }
        return res == INF ? -1 : res;
    }
}
