package haiwaitu.t20210813;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Author huangjunqiao
 * @Date 2021/08/14 17:19
 * @Description 1249. 移除无效的括号
 */
public class MinRemoveToMakeValid {
    /**
     * 相当于：20. 有效的括号 的进阶版，在判断括号有效的基础上，还要溢出无效的括号
     */
     public String minRemoveToMakeValid(String s) {
         // 栈+集合解法，时间：O(N)，空间：O(N)
         Deque<Integer> stack = new LinkedList<>();
         Set<Integer> set = new HashSet<>();
         int len = s.length();
         for (int i = 0; i < len; i++) {
             char c = s.charAt(i);
             if ('(' == c) {
                 stack.push(i);
             } else if (')' == c) {
                 if (stack.isEmpty()) {
                     // 记录不匹配的右括号
                     set.add(i);
                 } else {
                     stack.pop();
                 }
             }
         }
         while (!stack.isEmpty()) {
             // 不匹配的左括号添加到待删集合
             set.add(stack.pop());
         }
         StringBuilder sb = new StringBuilder();
         for (int i = 0; i < len; i++) {
             if (!set.contains(i)) {
                 sb.append(s.charAt(i));
             }
         }
         return sb.toString();
     }

     public String minRemoveToMakeValid0(String s) {
         // 动态字符串两步解法，时间：正向逆向遍历两次字符串，reverse()函数调用两次，一共O(4N)，即O(N)，空间：O(N)
         // 正向遍历，删除多余的右括号
         StringBuilder sb = rmInvalid(s, '(', ')');
         // 逆向遍历，删除多余的左括号
         sb = rmInvalid(sb.reverse(), ')', '(');
         return sb.reverse().toString();
     }
     public StringBuilder rmInvalid(CharSequence s, char open, char closing) {
         int len = s.length();
         int balanced = 0;
         StringBuilder sb = new StringBuilder();
         for (int i = 0; i < len; i++) {
             char c = s.charAt(i);
             if (c == open) {
                 balanced++;
             } else if (c == closing) {
                 if (balanced == 0) {
                     continue;
                 }
                 balanced--;
             }
             sb.append(c);
         }
         return sb;
     }

    public String minRemoveToMakeValid1(String s) {
        // 动态字符串优化解法，只需遍历一次，时间：O(N)，空间：O(N)
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        // 1、删除多余的右括号
        int openNum = 0;
        int balanced = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openNum++;
                balanced++;
            } else if (c == ')') {
                if (balanced == 0) {
                    continue;
                }
                balanced--;
            }
            sb.append(c);
        }
        StringBuilder res = new StringBuilder();
        int reserveOpen = openNum - balanced; // 需要保留的左括号数
        // 2、删除右边多余的左括号
        int sbLen = sb.length();
        for (int i = 0; i < sbLen; i++) {
            if (sb.charAt(i) == '(') {
                if (reserveOpen <= 0) {
                    continue;
                }
                reserveOpen--;
            }
            res.append(sb.charAt(i));
        }
        return res.toString();
    }
}
