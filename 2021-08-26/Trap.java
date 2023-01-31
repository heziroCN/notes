package haiwaitu.t20210826;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/08/26 10:50
 * @Description 42. 接雨水
 */
public class Trap {
    // 相似题目：84. 柱状图中最大的矩形
    public int trap(int[] height) {
        // 单调栈，时间：O(N)，空间：O(N)
        Deque<Integer> stk = new LinkedList<>();
        int len = height.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            while (!stk.isEmpty() && height[stk.peek()] < height[i]) {
                // 计算当前柱子对结果的贡献
                int top = stk.pop(), l = stk.peek();
                if (!stk.isEmpty()) {
                    int h = Math.min(height[l], height[i]) - height[top];
                    sum += h * (i - l - 1);
                }
            }
            stk.push(i);
        }
        return sum;
    }

    public int trap0(int[] height) {
        // 动态规划，时间：O(N)，空间：O(N)
        int len = height.length;
        int[] lMax = new int[len];// 左边最大值
        lMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            lMax[i] = Math.max(lMax[i - 1], height[i]);
        }
        int[] rMax = new int[len];// 右边最大值
        rMax[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], height[i]);
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.min(lMax[i], rMax[i]) - height[i];
        }
        return sum;
    }

    public int trap1(int[] height) {
        // 双指针（用两个指针代替DP解法的两个数组），时间：O(N)，空间：O(1)
        int lMax = 0, rMax = 0;
        int l = 0, r = height.length - 1;
        int sum = 0;
        while (l < r) {
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);
            // height[l]<height[r]必然有lMax<rMax，可以用反证法证明
            if (height[l] < height[r]) {
                sum += lMax - height[l];
                l++;
            } else {
                sum += rMax - height[r];
                r--;
            }
        }
        return sum;
    }

    public int trap2(int[] height) {
        // 维恩图解法，时间：O(N)，空间：O(1)
        int len = height.length;
        int s = 0, s1 = 0, s2 = 0;
        int lMax = 0, rMax = 0;
        for (int i = 0; i < len; i++) {
            s += height[i];
        }
        // s1+s2恰好为整个矩形的面积，并且柱子和积水部分重叠
        for (int i = 0; i < len; i++) {
            lMax = height[i] > lMax ? height[i] : lMax;
            s1 += lMax;
        }
        for (int i = len - 1; i >= 0; i--) {
            rMax = height[i] > rMax ? height[i] : rMax;
            s2 += rMax;
        }
        int area = lMax * len;
        return s1 + s2 - s - area;
    }
}
