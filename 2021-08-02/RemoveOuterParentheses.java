package haiwaitu.t20210802;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/08/02 23:53
 * @Description 1021. 删除最外层的括号
 */
public class RemoveOuterParentheses {
    // 题意：原语化分解后，即使会变成""也要去掉外层括号
     public String removeOuterParentheses(String s) {
         // 栈解法，时间O(NK)，K为原语化分解的子串数，N为字符串长度。空间O(N)
         int len = s.length();
         StringBuilder sb = new StringBuilder();
         Deque<Integer> stack = new LinkedList<>();
         for (int i = 0; i < len; i++) {
             if (s.charAt(i) == '(') {
                 stack.push(i);
             } else {
                 // 遇到")"出栈
                 int start = stack.pop();
                 if (stack.isEmpty()) {
                     sb.append(s.substring(start + 1, i));
                 }
             }
         }
         return sb.toString();
     }

    public String removeOuterParentheses0(String s) {
        int start = 0;
        int pair = 0;// 括号的对数
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                pair--;
            }
            // 需要去掉外层括号，所以pair >= 1才开始取字符
            if (pair >= 1) {
                sb.append(c);
            }
            if (c == '(') {
                pair++;
            }
        }
        return sb.toString();
    }
}
