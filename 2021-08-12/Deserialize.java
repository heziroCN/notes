package haiwaitu.t20210812;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/08/13 19:24
 * @Description
 */
public class Deserialize {
    int idx = 0;
    public NestedInteger deserialize(String s) {
        // 遇到左括号创建一个NestedInteger并压入栈，遇到逗号，add到栈顶的NestedInteger，遇到右括号出栈，时间O(N)，空间O(N)
        Deque<NestedInteger> stk = new LinkedList<>();
        int len = s.length();
        while (idx < len) {
            char c = s.charAt(idx);
            if ('[' == c) {
                NestedInteger sub = new NestedInteger();
                if (!stk.isEmpty()) {
                    stk.peek().add(sub);
                }
                stk.push(sub);
                idx++;
            } else if (',' == c) {
                idx++;
            } else if (']' == c) {
                if (stk.size() == 1) {
                    return stk.peek();
                }
                stk.pop();
                idx++;
            } else {
                // 只有数字而没有嵌套结构时，直接把数字作为value即可
                if (stk.isEmpty()) {
                    stk.push(new NestedInteger(getNum(s, len)));
                } else {
                    stk.peek().add(new NestedInteger(getNum(s, len)));
                }
            }
        }
        return stk.peek();
    }

    public int getNum(String s, int len) {
        int isPositive = 1;
        if ('-' == s.charAt(idx)) {
            isPositive = -1;
            idx++;
        }
        int num = 0;
        while (idx < len && Character.isDigit(s.charAt(idx))) {
            int curr = s.charAt(idx) - '0';
            num = num * 10 + curr;
            idx++;
        }
        return num * isPositive;
    }
}

class NestedInteger {
    public NestedInteger() {}
    public NestedInteger(int val) {
    }
    public void add(NestedInteger obj) {
    }
}
