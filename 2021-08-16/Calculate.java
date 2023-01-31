package haiwaitu.t20210816;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/08/17 13:57
 * @Description 224. 基本计算器
 */
public class Calculate {
    // 类似题型：227. 基本计算器 II
    int idx = 0;
    public int calculate(String s) {
        // 栈，时间O:(N)，空间O:(N)。每遇到一个"("前的"-"，括号内的正负号就要翻转一次，用栈记录当前层括号的符号
        int sign = 1;
        int len = s.length();
        Deque<Integer> stk = new LinkedList<>();
        stk.push(1);
        int res = 0;
        while (idx < len) {
            char c = s.charAt(idx);
            if (' ' == c) {
                idx++;
            } else if ('+' == c) {
                sign = stk.peek();
                idx++;
            } else if ('-' == c) {
                sign = -stk.peek();
                idx++;
            } else if ('(' == c) {
                stk.push(sign);
                idx++;
            } else if (')' == c) {
                stk.pop();
                idx++;
            } else {
                int num = 0;
                while (idx < len && Character.isDigit(s.charAt(idx))) {
                    num = num * 10 + s.charAt(idx++) - '0';
                }
                res += num * sign;
            }
        }
        return res;
    }
}
