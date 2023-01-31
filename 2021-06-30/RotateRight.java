package haiwaitu.t20210630;

import haiwaitu.ListNode;

/**
 * @Author huangjunqiao
 * @Date 2021/07/01 11:22
 * @Description 61. 旋转链表
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        // 时间O(N)，空间O(1)
        if (head == null || k == 0) {
            return head;
        }
        // 寻找断开点
        ListNode dummy = new ListNode(-101, head);
        ListNode node = dummy;
        int len = 0;
        while (node.next != null) {
            len++;
            node = node.next;
        }
        // 拼接成环
        node.next = head;
        // 找到断开点，断开
        int cnt = len - (k % len);
        while (cnt > 0) {
            node = node.next;
            cnt--;
        }
        ListNode newHead = node.next;
        node.next = null;
        return newHead;
    }
}
