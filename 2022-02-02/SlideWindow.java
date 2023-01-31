package haiwaitu.t20220202;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2022/02/03 18:16
 * @Description 滑动窗口
 */
public class SlideWindow {
    public int[] longestArea(int[] nums, int tar) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int sum = 0;
        int start = 0, end = 0;
        while (r < n) {
            sum += nums[r];// 添加 nums[l] 对结果的影响
            while (l <= r && !valid(tar, sum)) {
                sum -= nums[l++];// 移除 nums[r] 对结果的影响
            }
            if (r - l > end - start) {
                start = l;
                end = r;
            }
            r++;
        }
        return new int[] {start, end};
    }
    public boolean valid(int tar, int sum) {
        return sum >= tar;// 满足条件
    }

    public int[] shortestArea(int[] nums, int tar) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int sum = 0;
        int start = Integer.MIN_VALUE, end = Integer.MAX_VALUE;
        while (r < n) {
            sum += nums[r];// 添加 nums[l] 对结果的影响
            while (l <= r && !valid(tar, sum)) {
                sum -= nums[l++];// 移除 nums[r] 对结果的影响
            }
            if (r - l < end - start) {
                start = l;
                end = r;
            }
            r++;
        }
        return new int[] {start, end};
    }
}
