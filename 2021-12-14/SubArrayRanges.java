package haiwaitu.t20211214;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/12/15 23:58
 * @Description 2104. 子数组范围和
 */
public class SubArrayRanges {
    public long subArrayRanges(int[] nums) {
        // 双重循环，时间：O(N^2)，空间：O(1)
        int len = nums.length;
        long res = 0;
        for (int i = 0; i < len; i++) {
            int min = nums[i], max = nums[i];
            for (int j = i; j < len; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                res += (max - min);
            }
        }
        return res;
    }

    public long subArrayRanges0(int[] nums) {
        // 单调栈，时间：O(N)，空间：O(1)
        int len = nums.length;
        long res = 0;
        Deque<Integer> stk = new LinkedList<>();
        for (int i = 0; i <= len; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] > (i == len ? Integer.MIN_VALUE : nums[i])) {
                int j = stk.pop();
                int k = stk.isEmpty() ? -1 : stk.peek();
                res -= (long)nums[j] * (i - j) * (j - k);
            }
            stk.push(i);
        }
        stk.clear();
        for (int i = 0; i <= len; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] < (i == len ? Integer.MAX_VALUE : nums[i])) {
                int j = stk.pop();
                int k = stk.isEmpty() ? -1 : stk.peek();
                res += (long)nums[j] * (i - j) * (j - k);
            }
            stk.push(i);
        }
        return res;
    }
}
