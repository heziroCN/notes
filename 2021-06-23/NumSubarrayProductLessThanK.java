package haiwaitu.t20210623;

/**
 * @Author huangjunqiao
 * @Date 2021/06/24 16:58
 * @Description 713. 乘积小于K的子数组
 */
public class NumSubarrayProductLessThanK {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        // 双指针，时间O(N)，空间O(1)，类似题目为992. K 个不同整数的子数组
        if (k <= 1) {
            return 0;
        }
        int len = nums.length;
        int product = 1;
        int l = 0, r = 0;
        int res = 0;
        while (r < len) {
            product *= nums[r];
            // 如果k<=1，那么即使左指针追上甚至超过右指针，区间内没有数字了，product>=k依然成立，内层循环还是会继续循环
            while (product >= k) {
                product /= nums[l];
                l++;
            }
            res += r - l + 1;
            r++;
        }
        return res;
    }

}
