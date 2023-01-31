package haiwaitu.t20210804;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/08/05 01:09
 * @Description 1190. 反转每对括号间的子串
 */
public class ReverseParentheses {
     public String reverseParentheses(String s) {
         // 栈，时间：每层循环内，reverse操作复杂度O(N)，总时间O(N^2)，空间：O(N)
         Deque<String> stack = new LinkedList<>();
         StringBuilder sb = new StringBuilder();
         int len = s.length();
         for (int i = 0; i < len; i++) {
             char c = s.charAt(i);
             if ('(' == c) {
                 stack.push(sb.toString());
                 sb.setLength(0);
             } else if (')' == c) {
                 sb.reverse();
                 sb.insert(0, stack.pop());
             } else {
                 sb.append(c);
             }
         }
         return sb.toString();
     }

    public String reverseParentheses0(String s) {
        // 预处理，时间O(N)，空间O(N)
        int len = s.length();
        Deque<Integer> stack = new LinkedList<>();
        // 用数组记录左右括号的位置
        int[] pairs = new int[len];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pairs[i] = j;
                pairs[j] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        int step = 1;// 1或-1，向前或向后
        while (index < len) {
            char c = s.charAt(index);
            if (c == '(' || c == ')') {
                // 遇到括号时跳到对应的反括号位置，并反转移动方向
                index = pairs[index];
                step = -step;
            } else {
                // 遇到字母则继续拼接字符
                sb.append(c);
            }
            index += step;
        }
        return sb.toString();
    }
}
