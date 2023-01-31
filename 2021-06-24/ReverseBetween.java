package haiwaitu.t20210624;

import haiwaitu.ListNode;

/**
 * @Author huangjunqiao
 * @Date 2021/06/25 15:05
 * @Description 92. 反转链表 II
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 遍历两次待反转的区间，时间O(N)，空间O(1)，找到要反转的链表，断开。并记录断开处的相邻节点
        ListNode dummy = new ListNode(0, head);
        // 记录左右边界，方便断开后重新拼接。lPrev、rNode分别为左边界前一个节点和右边界节点
        ListNode lPrev = dummy;
        // 1. 找到左边界前一个节点
        for (int i = 0; i < left - 1; i++) {
            lPrev = lPrev.next;
        }
        // 2. 找到右边界
        ListNode rNode = lPrev;
        for (int i = 0; i < right - left + 1; i++) {
            rNode = rNode.next;
        }
        // 3.1 在左边界处断开
        ListNode lNode = lPrev.next;
        lPrev.next = null;
        // 3.2 在右边界处断开
        ListNode rNext = rNode.next;
        rNode.next = null;
        // 4. 反转链表
        reverse(lNode);
        // 5.1 左边拼接上反转后的链表
        lPrev.next = rNode;
        // 5.2 拼接右边
        lNode.next = rNext;
        return dummy.next;
    }
    ListNode reverse(ListNode head) {
        ListNode node = head, prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;

            prev = node;
            node = next;
        }
        return prev;
    }

    public ListNode reverseBetween0(ListNode head, int left, int right) {
        // 一次遍历，在需要反转的区间将每个找到的节点移动到区间头部。时间O(N)，空间O(1)
        ListNode dummy = new ListNode(0, head);
        ListNode lPrev = dummy;
        for (int i = 0; i < left - 1; i++) {
            lPrev = lPrev.next;
        }
        ListNode prev = lPrev;
        ListNode node = lPrev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = prev.next;
            prev.next = node.next;
            node.next = node.next.next;
            prev.next.next = next;
        }
        return dummy.next;
    }

}
