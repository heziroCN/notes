package haiwaitu.t20220210;

/**
 * @Author huangjunqiao
 * @Date 2022/02/11 16:14
 * @Description 1004. 最大连续1的个数 III
 */
public class LongestOnes {
    public int longestOnes(int[] nums, int k) {
        // 前缀和+二分，时间：O(nlogn)，空间：O(n)
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + 1 - nums[i - 1];
        }
        int res = 0;
        for (int right = 0; right < n; right++) {
            int left = binarySearch(prefix, prefix[right + 1] - k);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
    public int binarySearch(int[] prefix, int tar) {
        int l = 0, r = prefix.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (prefix[mid] < tar) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public int longestOnes0(int[] nums, int k) {
        // 前缀和+滑动窗口，时间：O(n)，空间：O(1)
        int n = nums.length;
        int lsum = 0, rsum = 0, left = 0;
        int res = 0;
        for (int right = 0; right < n; right++) {
            rsum += 1 - nums[right];
            while (rsum - lsum > k) {
                lsum += 1 - nums[left];
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
