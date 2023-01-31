package haiwaitu.t20211026;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/10/27 17:52
 * @Description 946. 验证栈序列
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 遍历pushed，按顺序入栈；同时校验栈顶元素是不是popped当前指向的元素，是则弹出。时间：O(N)，空间：O(N)
        Deque<Integer> stk = new LinkedList<>();
        int len = pushed.length;
        int idx = 0;
        for (int i = 0; i < len; i++) {
            stk.push(pushed[i]);
            while (idx < len && !stk.isEmpty() && stk.peek() == popped[idx]) {
                stk.pop();
                idx++;
            }
        }
        return stk.isEmpty();
    }
}
