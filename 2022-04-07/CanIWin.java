package haiwaitu.t20220407;

/**
 * @Author huangjunqiao
 * @Date 2022/04/07 16:15
 * @Description 464. 我能赢吗
 */
public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 时间：O(n*2^n)，空间：O(2^n)，n为可选数字范围
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) {
            return false;
        }
        return dfs(0, new Boolean[1 << maxChoosableInteger], maxChoosableInteger, desiredTotal);
    }
    public boolean dfs(int state, Boolean[] dp, int max, int desire) {
        // state不但表示哪些数被选了，还包含【当前是谁的回合】这个信息
        if (dp[state] != null) {
            return dp[state];
        }
        for (int i = 1; i <= max; i++) {
            int cur = 1 << (i - 1);
            if ((state & cur) != 0) {
                continue;
            }
            if (i >= desire || !dfs(state | cur, dp, max, desire - i)) {// 双方都采取最优策略，即在可选方案中只需要有一种能赢对方的方案即算当前选手赢。
                return dp[state] = true;
            }
        }
        return dp[state] = false;
    }
}
