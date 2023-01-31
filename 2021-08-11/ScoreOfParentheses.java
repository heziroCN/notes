package haiwaitu.t20210811;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/08/12 15:57
 * @Description 856. 括号的分数
 */
public class ScoreOfParentheses {
    /**
     * 类似题型有 394. 字符串解码，都是在处理嵌套的括号同时需要关注嵌套的深度
     */
    public int scoreOfParentheses(String s) {
        // 栈维护深度和每层深度的得分，时间O(N)，空间O(N)
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                stack.push(0);
            } else {
                int inner = stack.pop();
                int outer = stack.pop();
                stack.push(outer + Math.max(inner * 2, 1));
            }
        }
        return stack.peek();
    }

    public static int scoreOfParentheses0(String s) {
        // 按深度统计分数，找到每一个()对应的深度x，那么分数就是2^x。时间：O(N)，空间：O(1)
        int depth = 0, ans = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                depth++;
            } else {
                depth--;
                if ('(' == s.charAt(i - 1)) {
                    ans += 1 << depth;
                }
            }
        }
        return ans;
    }

    public int scoreOfParentheses1(String s) {
        // 分治，时间：O(n^2)，空间：O(n)
        return f(s, 0, s.length() - 1);
    }
    public int f(String s, int l, int r) {
        int res = 0, score = 0;
        for (int i = l; i <= r; i++) {
            score += s.charAt(i) == '(' ? 1 : -1;
            if (score == 0) {
                if (i - l == 1) {
                    res++;
                } else {
                    res += 2 * f(s, l + 1, i - 1);
                }
                l = i + 1;
            }
        }
        return res;
    }

}
