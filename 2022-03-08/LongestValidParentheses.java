package haiwaitu.t20220308;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2022/03/12 08:29
 * @Description 32. 最长有效括号
 */
public class LongestValidParentheses {
     public int longestValidParentheses(String s) {
         // dp，时间：O(n)，空间：O(n)
         int n = s.length();
         int[] dp = new int[n];
         int res = 0;
         for (int i = 1; i < n; i++) {
             if (s.charAt(i) == ')') {
                 if (s.charAt(i - 1) == '(') {
                     dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                 } else if (i - dp[i - 1] >= 1 && s.charAt(i - dp[i - 1] - 1) == '(') {
                     dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                 }
             }
             res = Math.max(res, dp[i]);
         }
         return res;
     }

     public int longestValidParentheses0(String s) {
         // 时间：O(n)，空间：O(n)
         int n = s.length();
         Deque<Integer> stk = new LinkedList<>();
         stk.push(-1);
         int res = 0;
         for (int i = 0; i < n; i++) {
             if (s.charAt(i) == '(') {
                 stk.push(i);
             } else {
                 stk.pop();
                 if (stk.isEmpty()) {
                     stk.push(i);
                 } else {
                     res = Math.max(res, i - stk.peek());
                 }
             }
         }
         return res;
     }

    public int longestValidParentheses1(String s) {
        // 统计左右括号数量，时间：O(n)，空间：O(1)
        int n = s.length(), max = 0;
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left * 2);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left * 2);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return max;
    }
}
