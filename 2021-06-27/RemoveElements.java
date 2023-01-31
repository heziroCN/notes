package haiwaitu.t20210627;

import haiwaitu.ListNode;

/**
 * @Author huangjunqiao
 * @Date 2021/06/28 12:04
 * @Description 203. 移除链表元素
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        // 时间O(N)，空间O(1)
        ListNode dummy = new ListNode(-1, head);
        ListNode node = dummy;
        while (node.next != null) {
            if (val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return dummy.next;
    }
}
