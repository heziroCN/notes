package haiwaitu.t20210730;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author huangjunqiao
 * @Date 2021/07/31 19:15
 * @Description 20. 有效的括号
 */
public class IsValid {
    public boolean isValid(String s) {
        // 借助哈希表的栈解法，时间O(N)，空间O(N)
        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        // 哈希表以“闭符号”为键，“开符号”为值。遇到键中存在的字符（即闭符号），则检查以栈顶字符是否为配对的开符号，是则配对成功，弹出栈顶字符，配对失败说明字符串不是有效的。
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
