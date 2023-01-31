package haiwaitu.t20211024;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author huangjunqiao
 * @Date 2021/10/25 11:27
 * @Description 264. 丑数 II
 */
public class NthUglyNumber {
    public int nthUglyNumber0(int n) {
        // 堆+哈希表，时间：O(nlogn)，空间：O(n)
        int[] factors = {2, 3, 5};
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        set.add(1L);
        pq.offer(1L);
        long num = 1L;
        for (int i = 0; i < n; i++) {
            num = pq.poll();
            for (int factor : factors) {
                long next = num * factor;
                if (!set.contains(next)) {
                    set.add(next);
                    pq.offer(next);
                }
            }
        }
        return (int) num;
    }

    public int nthUglyNumber(int n) {
        // DP+三指针，时间：O(n)，空间：O(n)
        int[] dp = new int[n + 1];// dp[i]表示第i个丑数
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5));
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
