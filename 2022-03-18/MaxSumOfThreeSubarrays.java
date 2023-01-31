package haiwaitu.t20220318;

/**
 * @Author huangjunqiao
 * @Date 2022/03/19 15:00
 * @Description 689. 三个无重叠子数组的最大和
 */
public class MaxSumOfThreeSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // 滑动窗口，时间：O(n)，空间：O(1)
        int n = nums.length;
        int sum1 = 0, maxSum1 = 0, maxSum1Idx = 0;
        int sum2 = 0, maxSum12 = 0, maxSum12Idx1 = 0, maxSum12Idx2 = 0;
        int sum3 = 0, total = 0;
        int[] res = new int[3];
        for (int i = k * 2; i < n; i++) {
            sum1 += nums[i - k * 2];
            sum2 += nums[i - k];
            sum3 += nums[i];
            if (i >= k * 3 - 1) {
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    maxSum1Idx = i - k * 3 + 1;
                }
                if (maxSum1 + sum2 > maxSum12) {
                    maxSum12 = maxSum1 + sum2;
                    maxSum12Idx1 = maxSum1Idx;
                    maxSum12Idx2 = i - k * 2 + 1;
                }
                if (maxSum12 + sum3 > total) {
                    total = maxSum12 + sum3;
                    res[0] = maxSum12Idx1;
                    res[1] = maxSum12Idx2;
                    res[2] = i - k + 1;
                }
                sum1 -= nums[i - k * 3 + 1];
                sum2 -= nums[i - k * 2 + 1];
                sum3 -= nums[i - k + 1];
            }
        }
        return res;
    }
}
