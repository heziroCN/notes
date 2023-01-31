package haiwaitu.t20211213;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/12/14 22:21
 * @Description 907. 子数组的最小值之和
 */
public class SumSubarrayMins {
    public int sumSubarrayMins(int[] arr) {
        // 两个单调栈，一个存储左边第一个比当前数字小的下标l，一个存储右边第一个比当前数字小的下标r，则当前数字就是区间[l,r]内的极小值。时间：O(N)，空间：O(N)
        int len = arr.length;
        int[] left = new int[len], right = new int[len];
        Deque<Integer> stk1 = new LinkedList<>(), stk2 = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            // stk1和stk2其中一个在判断弹出条件时取<=即可，用于去重（遇到连续重复的元素取第一个或最后一个）
            while (!stk1.isEmpty() && arr[i] <= arr[stk1.peek()]) {
                stk1.pop();
            }
            left[i] = stk1.isEmpty() ? -1 : stk1.peek();
            stk1.push(i);
        }
        for (int i = len - 1; i >= 0; i--) {
            while (!stk2.isEmpty() && arr[i] < arr[stk2.peek()]) {
                stk2.pop();
            }
            right[i] = stk2.isEmpty() ? len : stk2.peek();
            stk2.push(i);
        }
        int MOD = 1_000_000_007;
        long res = 0;
        // 左区间[i,k]包含arr[k]的子数组有k-i个，右区间[k,j]包含arr[k]的子数组有j-k个，根据排列组合，[i,j]内包含arr[k]的子数组有(k-i)(j-k)个
        for (int i = 0; i < len; i++) {
            res += (long) (i - left[i]) * (right[i] - i) % MOD * arr[i] % MOD;
            res %= MOD;
        }
        return (int) res;
    }
}
