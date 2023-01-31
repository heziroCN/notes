package haiwaitu.t20220214;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2022/02/15 14:47
 * @Description 673. 最长递增子序列的个数
 */
public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int len = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            len = Math.max(len, dp[i]);
        }
        int cnt = 1, idx = n - 1;
        while (len > 1) {
            while (idx > 0 && dp[idx] == len) {
                idx--;
            }
            len--;
        }
        return cnt;
    }

    public static void main(String[] args) {
        FindNumberOfLIS o = new FindNumberOfLIS();
        int[] nums = {1,3,5,4,7};
        System.out.println(o.findNumberOfLIS(nums));
    }
}
