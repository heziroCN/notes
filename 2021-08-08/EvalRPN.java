package haiwaitu.t20210808;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/08/10 18:27
 * @Description 150. 逆波兰表达式求值
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        // 栈，时间：O(N)，空间：O(N)
        Deque<Integer> stack = new LinkedList<>();
        int len = tokens.length;
        for (int i = 0; i < len; i++) {
            String str = tokens[i];
            int num1 = 0, num2 = 0;
            if ("+".equals(str)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(str)) {
                num2 = stack.pop();
                num1 = stack.pop();
                stack.push(num1 - num2);
            } else if ("*".equals(str)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(str)) {
                num2 = stack.pop();
                num1 = stack.pop();
                stack.push(num1 / num2);
            } else {
                // 数字直接入栈
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.peek();
    }
}
