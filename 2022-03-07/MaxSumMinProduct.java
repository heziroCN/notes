package haiwaitu.t20220307;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2022/03/07 22:44
 * @Description 1856. 子数组最小乘积的最大值
 */
public class MaxSumMinProduct {
    public int maxSumMinProduct(int[] nums) {
        // 单调栈+前缀和，时间：O(n)，空间：O(n)
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        Deque<Integer> stk = new LinkedList<>();
        int[] left = new int[n], right = new int[n];//左边和右边第一个小于nums[i]的坐标
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && nums[i] < nums[stk.peek()]) {
                right[stk.pop()] = i;
            }
            stk.push(i);
        }
        stk.clear();
        Arrays.fill(left, -1);
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && nums[i] < nums[stk.peek()]) {
                left[stk.pop()] = i;
            }
            stk.push(i);
        }

        long res = 0L;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, nums[i] * (prefix[right[i]] - prefix[left[i] + 1]));
        }
        return (int) (res % 1000_000_007);
    }
}
