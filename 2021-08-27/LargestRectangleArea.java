package haiwaitu.t20210827;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/08/27 12:09
 * @Description 84. 柱状图中最大的矩形
 */
public class LargestRectangleArea {
    // 相似题目：42. 接雨水
    public int largestRectangleArea(int[] heights) {
        // 单调栈枚举高，使用单调栈分别找到左右最近的高度较小的柱子，时间：O(N)，空间：O(N)
        Deque<Integer> stk = new LinkedList<>();
        int len = heights.length;
        int[] left = new int[len];// 存储左边最近的高度较小柱子
        for (int i = 0; i < len; i++) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }
            left[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }
        stk.clear();
        int[] right = new int[len];// 存储右边最近的高度较小柱子
        for (int i = len - 1; i >= 0; i--) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }
            right[i] = stk.isEmpty() ? len : stk.peek();
            stk.push(i);
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        }
        return max;
    }
    public int largestRectangleArea0(int[] heights) {
        // 单调栈+常数优化，一次遍历找到左右边界。时间：O(N)，空间：O(N)
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(right, len);
        Deque<Integer> stk = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                // i为stk.peek()右边界，如果i和stk.peek()之间还有小于stk.peek()的元素，这个元素会先于i把stk.peek()弹出栈。
                right[stk.peek()] = i;
                stk.pop();
            }
            left[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        }
        return max;
    }
}
