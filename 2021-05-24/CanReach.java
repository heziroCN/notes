package haiwaitu.t20210524;

/**
 * @Author huangjunqiao
 * @Date 2021/05/24 22:58
 * @Description 5765. 跳跃游戏 VII(242周赛)
 */
public class CanReach {
    public boolean canReach(String s, int minJump, int maxJump) {
        // 暴力dp+剪枝，时间O(mn)，m=maxJum-minJump，空间O(n)
        int len = s.length();
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '1') {
                continue;
            }
            for (int j = minJump; j <= maxJump; j++) {
                if (i - j < 0) {
                    break;
                }
                if (dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len - 1];
    }
    public boolean canReach0(String s, int minJump, int maxJump) {
        // 官方解法：dp+前缀优化，时间O(n)，空间O(n)
        int len = s.length();
        boolean[] dp = new boolean[len];
        dp[0] = true;
        int[] pre = new int[len];
        // 初始化前缀
        for (int i = 0; i < minJump; i++) {
            pre[i] = 1;
        }
        for (int i = minJump; i < len; i++) {
            int left = i - maxJump;
            int right = i - minJump;
            // pre[right]-right[left - 1]>0说明[left,right]直接有“落脚点”
            if (s.charAt(i) == '0') {
                int total = pre[right] - (left <= 0 ? 0 : pre[left - 1]);
                dp[i] = total != 0;
            }
            pre[i] = dp[i] ? pre[i - 1] + 1 : pre[i - 1];
        }
        return dp[len - 1];
    }
}
