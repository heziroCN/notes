package haiwaitu.t20220116;

/**
 * @Author huangjunqiao
 * @Date 2022/01/16 20:34
 * @Description 5982. 解决智力问题
 */
public class MostPoints {
    public long mostPoints(int[][] questions) {
        // 逆向dp，从后向前算得分
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int[] q = questions[i];
            int iJump = i + q[1] + 1;
            dp[i] = Math.max(dp[i + 1], q[0] + (iJump < n ? dp[iJump] : 0));
        }
        return dp[0];
    }
}
