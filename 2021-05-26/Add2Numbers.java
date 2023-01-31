package haiwaitu.t20210525;

import haiwaitu.ListNode;

import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/05/25 16:21
 * @Description 445. 两数相加 II
 */
public class Add2Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 时间两个链表出入栈各一次，复杂度O(N+M)，空间只用到了几个指针，复杂度O(1)，
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        ListNode idx1 = l1,idx2 = l2;
        // 两链表入栈，方便从低位开始相加
        while (idx1 != null) {
            stack1.offer(idx1.val);
            idx1 = idx1.next;
        }
        while (idx2 != null) {
            stack2.offer(idx2.val);
            idx2 = idx2.next;
        }
        int carry = 0;
        ListNode result = null;
        // 逐位相加
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int curr = carry;
            if (!stack1.isEmpty()) {
                curr += stack1.pollLast();
            }
            if (!stack2.isEmpty()) {
                curr += stack2.pollLast();
            }
            carry = curr / 10;
            // 逆向拼接节点，构建相加后的结果链表
            ListNode currNode = new ListNode(curr % 10);
            currNode.next = result;
            result = currNode;
        }
        return result;
    }
}
