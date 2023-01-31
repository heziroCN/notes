package haiwaitu.t20210629;

import haiwaitu.ListNode;

/**
 * @Author huangjunqiao
 * @Date 2021/06/30 18:21
 * @Description 86. 分隔链表
 */
public class Partition {
    /**
     * 官方解法，把<x的节点连接成一个链表，>=x的节点连接成另一个链表，然后拼接两个链表
     * 时间O(N)，空间O(1)
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        // 1. define pointers small and large
        ListNode smallHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode largeHead = new ListNode(0);
        ListNode large = largeHead;
        // 2. small search nodes smaller than x, and large search the others
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        // 3. connect small to large
        small.next = largeHead.next;
        // 4. as the new tali, large should not point to any node,set its next to null
        large.next = null;
        return smallHead.next;
    }

    /**
     * 找到第一个>=x的节点作为边界，边界后面所有小于x的节点都"移"到边界前面
     * 时间O(N)，空间O(1)
     * @param head
     * @param x
     * @return
     */
    public ListNode partition0(ListNode head, int x) {
        // 1.find the first node which >= x
        ListNode dummy = new ListNode(0, head);
        ListNode bound = dummy;
        while (bound.next != null && bound.next.val < x) {
            bound = bound.next;
        }
        // 2.find the node < x behind bound
        ListNode node = bound;
        while (node.next != null) {
            if (node.next.val >= x) {
                node = node.next;
            } else {
                // 3.put them behind bound
                ListNode small = node.next;
                node.next = node.next.next;

                ListNode boundNext = bound.next;
                bound.next = small;
                small.next = boundNext;
                // 4.move bound forward
                bound = bound.next;
            }
        }
        return dummy.next;
    }
}
