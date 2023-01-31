package haiwaitu.t20210512;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/05/13 10:50
 * @Description 1290. 二进制链表转整数
 */
public class GetDecimalValue {
    public int getDecimalValue0(ListNode head) {
        // 借助栈 时间O()，空间O(1)
        Deque<Integer> stack = new LinkedList<>();
        ListNode node = head;
        // 链表节点放入栈中，方便从个位向高位访问
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        int count = 0;
        int result = 0;
        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (num == 1) {
                result += num << count;
            }
            count++;
        }
        return result;
    }

    public int getDecimalValue(ListNode head) {
        // 无需栈 时间O(N) 空间O(1)
        int result = 0;
        while (head != null) {
            result = result * 2 + head.val;
            head = head.next;
        }
        return result;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
