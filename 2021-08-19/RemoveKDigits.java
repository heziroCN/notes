package haiwaitu.t20210819;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/08/20 00:08
 * @Description 402. 移掉 K 位数字
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        // 要使数字最小，就要尽可能使较小的数字排在高位，用单调栈。
        // 单调栈，时间：O(N)，空间：O(N)
        Deque<Character> stk = new LinkedList<>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char c = num.charAt(i);
            while (k > 0 && !stk.isEmpty() && stk.peek() > c) {
                stk.pop();
                k--;
            }
            if (!stk.isEmpty() || c != '0') {// 避免出现前导0
                stk.push(c);
            }
        }
        while (!stk.isEmpty() && k > 0) {
            stk.pop();
            k--;
        }
        // 使用双向队列的API方便组织数据
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pollLast());
        }
        return sb.toString().equals("") ? "0" : sb.toString();
    }
}
