package haiwaitu.t20210426;

/**
 * @Author huangjunqiao
 * @Date 2021/04/26 14:48
 * @Description 300. 最长递增子序列
 */
public class LengthOfLIS {

    /**
     * dp[i]存储以nums[i]为结尾的最大升序子序列长度，可得状态转移方程
     * dp[i] = 1 + max(dp[j]),j < i且nums[j] < nums[i]
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        // 动态规划解法
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        // 至少长度为1
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // dp[i]代表以nums[i]为结尾的子序列，这里才可以这样比较
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 更新最大长度
            result = Math.max(dp[i], result);
        }
        return result;
    }

}
