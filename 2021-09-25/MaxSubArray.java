package haiwaitu.t20210925;

/**
 * @Author huangjunqiao
 * @Date 2021/09/25 00:50
 * @Description 剑指 Offer 42. 连续子数组的最大和
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        // 分析数组特点，时间：O(N)，空间：O(1)
        int currSum = nums[0], max = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (currSum < 0) {
                // 如果之前累加的结果小于0，对于总结果的贡献为负，可以抛弃掉
                currSum = nums[i];
            } else {
                currSum += nums[i];
            }
            max = Math.max(max, currSum);
        }
        return max;
    }
}
