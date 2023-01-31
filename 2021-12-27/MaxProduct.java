package haiwaitu.t20211227;

/**
 * @Author huangjunqiao
 * @Date 2021/12/28 15:35
 * @Description 152. 乘积最大子数组
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        // 动态规划，时间：O(N)，空间：O(N)
        int len = nums.length;
        // maxDp[], minDp[]分别记录最大和最小的乘积，由于负数的存在，maxDp[i]可能从maxDp[i-1]转移而来，也可能从minDp[i-1]转移而来
        int[] maxDp = new int[len], minDp = new int[len];
        maxDp[0] = minDp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            maxDp[i] = Math.max(nums[i] * minDp[i - 1], Math.max(nums[i], nums[i] * maxDp[i - 1]));
            minDp[i] = Math.min(nums[i] * maxDp[i - 1], Math.min(nums[i], nums[i] * minDp[i - 1]));
            res = Math.max(res, maxDp[i]);
        }
        return res;
    }
}
