package haiwaitu.t20220201;

/**
 * @Author huangjunqiao
 * @Date 2022/02/03 17:16
 * @Description 416. 分割等和子集
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        // 时间：O(n*target)，空间：O(n*target)
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int max = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        int target = sum / 2;
        if (sum % 2 != 0 || max > target) {
            return false;
        }

        boolean[][] dp = new boolean[n][target + 1];
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }

    public boolean canPartition0(int[] nums) {
        // 时间：O(n*target)，空间：O(target)
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int max = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        int target = sum / 2;
        if (sum % 2 != 0 || max > target) {
            return false;
        }

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
