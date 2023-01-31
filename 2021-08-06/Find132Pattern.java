package haiwaitu.t20210806;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @Author huangjunqiao
 * @Date 2021/08/06 21:55
 * @Description 456. 132 模式
 */
public class Find132Pattern {
    public boolean find132pattern(int[] nums) {
        // 红黑树枚举1，时间：O(nlogn)，空间：O(n)
        int n = nums.length;
        TreeMap<Integer, Integer> right = new TreeMap<>();
        for (int k = 2; k < n; k++) {
            right.put(nums[k], right.getOrDefault(nums[k], 0) + 1);
        }
        int leftMin = nums[0];
        for (int j = 1; j < n - 1; j++) {
            Integer numk = right.ceilingKey(leftMin + 1);
            if (numk != null && numk > leftMin && numk < nums[j]) {
                return true;
            }
            leftMin = Math.min(leftMin, nums[j]);
            right.put(nums[j + 1], right.get(nums[j + 1]) - 1);
            if (right.get(nums[j + 1]) == 0) {
                right.remove(nums[j + 1]);
            }
        }
        return false;
    }

    public boolean find132pattern0(int[] nums) {
        // 单调栈枚举1，时间：O(n)，空间：O(n)
        int n = nums.length;
        Deque<Integer> stk = new LinkedList<>();
        int maxk = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (maxk > nums[i]) {
                return true;
            }
            while (!stk.isEmpty() && stk.peek() < nums[i]) {
                maxk = stk.pop();
            }
            stk.push(nums[i]);
        }
        return false;
    }
}
