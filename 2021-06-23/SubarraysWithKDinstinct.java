package haiwaitu.t20210623;

/**
 * @Author huangjunqiao
 * @Date 2021/06/24 16:21
 * @Description 992. K 个不同整数的子数组
 */
public class SubarraysWithKDinstinct {
    /**
     * 不直观的问题转化为直观的子问题求解。求”恰好有k个不同整数的子数组“可以转化为
     * ”至多k个不同整数的子数组“与”至多k-1个不同整数的子数组“的差。
     */
    public int subarraysWithKDistinct(int[] nums, int k) {
        // 双指针滑动窗口解法，O(N)，空间O(N)，类似题目713. 乘积小于K的子数组
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }
    public int atMostKDistinct(int[] nums, int k) {
        // 求解至多k个不同整数的子数组
        int l = 0, r = 0;
        int len = nums.length;
        int cnt = 0;
        // 当前子数组的数字频率
        int[] freq = new int[len + 1];
        int res = 0;
        while (r < len) {
            if (freq[nums[r]] == 0) {
                // freq[n]为0表示n在子数组是第一次出现
                cnt++;
            }
            freq[nums[r]]++;
            r++;
            while (cnt > k) {
                freq[nums[l]]--;
                if (freq[nums[l]] == 0) {
                    cnt--;
                }
                l++;
            }
            // 左边界固定的前提下，随着右边界的移动，产生新的子区间的个数恰好等于区间长度减一，即r-l
            res += r - l;
        }
        return res;
    }
}
