package haiwaitu.t20210622;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2021/06/23 08:55
 * @Description 16. 最接近的三数之和
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        // 双指针+剪枝，类似于 15. 三数之和 与 18. 四数之和 ，核心思路都是使用双指针将两重循环优化为一重，时间O(N^2)，空间O(1)。
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 跳过连续重复数，只取重复的第一个，通过判断与前一个数是否相等来进行。如果取最后一个，指针i跳过的重复数，连带指针l也跳过了这些重复数，可能错过正确答案。
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = len - 1;
            while (l < r) {
                // 跳过连续重复数，取重复的最后一个有两个原因：1、nums[i]取的是重复的第一个，那么nums[l]必须取最后一个才能配合外层的剪枝，实现跳过连续的重复；
                // 2、nums[l]前一个数可能是nums[i]，所以不能再判断与前一个数是否相等，而只能判断是否与后一个数相等来实现剪枝。
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (sum < target) {
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    l++;
                } else {
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    r--;
                }
            }
        }
        return closest;
    }

}
