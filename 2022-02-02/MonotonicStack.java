package haiwaitu.t20220202;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2022/02/03 17:58
 * @Description 单调栈
 */
public class MonotonicStack {
    /**
     * 对于每一个元素，找到左边第一个比它大的元素的索引
     * @return
     */
    public int[] leftLarger(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stk = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && nums[i] > nums[stk.peek()]) {
                res[stk.pop()] = i;
            }
            stk.push(i);
        }
        return res;
    }

    /**
     * 对于每一个元素，找到右边第一个比它大的元素的索引
     * @param nums
     * @return
     */
    public int[] rightLarger(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stk = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && nums[i] > nums[stk.peek()]) {
                res[stk.pop()] = i;
            }
            stk.push(i);
        }
        return res;
    }
}
