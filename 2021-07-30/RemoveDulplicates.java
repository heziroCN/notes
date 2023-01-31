package haiwaitu.t20210730;

/**
 * @Author huangjunqiao
 * @Date 2021/07/31 22:36
 * @Description 1047. 删除字符串中的所有相邻重复项
 */
public class RemoveDulplicates {
    public String removeDuplicates(String s) {
        // 用StringBuilder模拟栈，时间O(N)，空间O(N)
        int len = s.length();
        StringBuilder stack = new StringBuilder();
        int top = -1;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 栈里已经没有字符，或者栈顶字符与当前字符不同，则入栈
            if (top < 0 || c != stack.charAt(top)) {
                stack.append(s.charAt(i));
                top++;
            } else {
                // 栈里的字符与当前字符相同，则消除
                stack.deleteCharAt(top);
                top--;
            }
        }
        return stack.toString();
    }
}
