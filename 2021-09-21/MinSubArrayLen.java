package haiwaitu.t20210921;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2021/09/21 17:59
 * @Description 209. 长度最小的子数组
 */
public class MinSubArrayLen {
     public int minSubArrayLen(int target, int[] nums) {
         // 滑动窗口解法，时间：O(N)，空间：O(1)
         int n = nums.length;
         int l = 0, r = 0;
         int res = n + 1, currSum = 0;
         while (r < n) {
             currSum += nums[r];
             while (currSum >= target) {
                 res = Math.min(res, r - l + 1);
                 currSum -= nums[l++];
             }
             r++;
         }
         return res == (n + 1) ? 0 : res;
     }

    public int minSubArrayLen0(int target, int[] nums) {
        // 前缀和+二分查找，时间：O(N)，空间：O(N)
        int n = nums.length;
        int res = n + 1;
        int[] prefix = new int[n + 1];// prefix[0]=0表示前0个元素和为0
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        // 问题转化为求满足prefix[j] - prefix[i] >= target(i < j)的最小j-i，可以枚举每个prefix[i]并二分查找prefix[j]
        for (int i = 1; i <= n; i++) {
            int currTarget = prefix[i - 1] + target;
            int j = Arrays.binarySearch(prefix, currTarget);
            if (j < 0) {
                j = -j - 1;
            }
            if (j <= n) {
                res = Math.min(res, j - i + 1);
            }
        }
        return res == n + 1 ? 0 : res;
    }
    public int bSearch(int[] nums, int tar) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < tar) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
