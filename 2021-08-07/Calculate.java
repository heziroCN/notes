package haiwaitu.t20210807;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/08/10 00:17
 * @Description 227. 基本计算器 II
 */
public class Calculate {
    public int calculate(String s) {
        // 栈，时间：O(N)，空间：O(N)
        int len = s.length();
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int num = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            // 如果当前字符为+ - * /，计算前面字符的运算结果
            if ((!Character.isDigit(c) && c != ' ') || i == len - 1) {
                if ('+' == preSign) {
                    stack.push(num);
                } else if ('-' == preSign) {
                    stack.push(-num);
                } else if ('*' == preSign) {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }
                preSign = c;
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    int i = 0;
    public int calculate0(String s) {
        // 变量代替栈，时间：O(N)，空间：O(1)
        int isPositive = 1;
        int n = s.length();
        int preNum = 0;
        int res = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
            } else if (c == '+') {
                res += preNum * isPositive;
                isPositive = 1;
                i++;
            } else if (c == '-') {
                res += preNum * isPositive;
                isPositive = -1;
                i++;
            } else if (c == '*') {
                int num = getNextNum(s, n);
                preNum *= num;
            } else if (c == '/') {
                int num = getNextNum(s, n);
                preNum /= num;
            } else {
                preNum = getNextNum(s, n);
            }
        }
        res += preNum * isPositive;
        return res;
    }
    public int getNextNum(String s, int n) {
        int num = 0;
        while (i < n && !Character.isDigit(s.charAt(i))) {
            i++;
            continue;
        }
        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + s.charAt(i++) - '0';
        }
        return num;
    }
}
