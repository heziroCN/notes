package haiwaitu.t20220114;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2022/01/15 13:12
 * @Description 354. 俄罗斯套娃信封问题
 */
public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        // dp，时间：O(n^2)，空间：O(n)
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxEnvelopes0(int[][] envelopes) {
        // 贪心二分+dp，时间：O(nlogn)，空间：O(n)
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int n = envelopes.length;
        int[][] d = new int[n + 1][2];// dp[i]表示长度为i的信封子序列的最小末尾宽高组合
        int len = 1;
        d[1] = envelopes[0];
        for (int i = 1; i < n; i++) {
            if (envelopes[i][1] > d[len][1]) {
                d[++len] = envelopes[i];
            } else if (envelopes[i][1] < d[1][1]) {
                d[1] = envelopes[i];
            } else {
                int l = 1, r = len;
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (envelopes[i][1] > d[mid][1]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                d[r] = envelopes[i];
            }
        }
        return len;
    }
}
