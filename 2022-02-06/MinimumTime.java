package haiwaitu.t20220206;

/**
 * @Author huangjunqiao
 * @Date 2022/02/06 21:37
 * @Description 6003. 移除所有载有违禁货物车厢所需的最少时间
 */
public class MinimumTime {
    public int minimumTime(String s) {
        // 问题转化成寻找最小子数组和:len(left) + count(middle, '1')*2 + len(right)
        // =len(left) + len(right) + count(middle, '1') + count(middle, '0') + len(right) + count(middle, '1') - count(middle, '0')
        // =n + count(middle, '1') - count(middle, '0')
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) == '1' ? 1 : -1;
        }
        return n + minSubArraySum(nums);
    }
    public int minSubArraySum(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];//表示以i结尾的子数组最小和
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(nums[i], dp[i - 1] + nums[i]);
            res = Math.min(res, dp[i]);
        }
        return Math.min(res, 0);
    }
}
