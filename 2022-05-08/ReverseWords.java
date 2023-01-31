package haiwaitu.t20220508;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2022/05/09 09:46
 * @Description 151. 颠倒字符串中的单词
 */
public class ReverseWords {
    public String reverseWords(String s) {
        // 双端队列，时间：O(n)，空间：O(n)
        Deque<String> stk = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (sb.length() > 0) {
                    stk.push(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            stk.push(sb.toString());
        }
        StringBuilder res = new StringBuilder();
        while (!stk.isEmpty()) {
            res.append(stk.pop());
            if (!stk.isEmpty()) {
                res.append(" ");
            }
        }
        return res.toString();
    }
}
