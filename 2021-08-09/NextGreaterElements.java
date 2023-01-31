package haiwaitu.t20210809;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/08/10 23:45
 * @Description 503. 下一个更大元素 II
 */
public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        // 单调栈存储下标，栈底到栈顶对应的数字单调递减，时间：O(N)，空间：O(N)
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < 2 * len - 1; i++) {
            // 把栈顶比nums[i]小的数字都弹出来，nums[i]就是这些数字的下一个最大值
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }
        return res;
    }
}
