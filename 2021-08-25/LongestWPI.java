package haiwaitu.t20210825;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/08/25 04:29
 * @Description 1124. 表现良好的最长时间段
 */
public class LongestWPI {
    public int longestWPI(int[] hours) {
        // 前缀和+单调栈，时间：O(N)，空间：O(N)
        int len = hours.length;
        // 大于8小时记为1分，小于等于8记为-1分
        int[] score = new int[len];
        for (int i = 0; i < len; i++) {
            score[i] = hours[i] > 8 ? 1 : -1;
        }
        // 针对得分计算前缀和，记录在presum数组里。寻找符合presum[j]>presum[i]的最大(j-i)
        int[] presum = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            presum[i] = presum[i - 1] + score[i - 1];
        }
        // presum[i]越小，越有可能产生presum[j]>presum[i]，所以栈单调递减
        Deque<Integer> stk = new LinkedList<>();
        for (int i = 0; i < len + 1; i++) {
            if (stk.isEmpty() || presum[stk.peek()] > presum[i]) {
                stk.push(i);
            }
        }
        int ans = 0;
        for (int i = len; i >= 0; i--) {
            while (!stk.isEmpty() && presum[stk.peek()] < presum[i]) {
                ans = Math.max(ans, i - stk.pop());
            }
        }
        return ans;
    }
}
