package haiwaitu.t20210423;

import haiwaitu.t20210422.HasCycle;

/**
 * @Author huangjunqiao
 * @Date 2021/04/23 12:00
 * @Description
 */
public class ReverseList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 迭代解法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode node = head;
        ListNode next = null;
        while (node != null) {
            // 缓存下一个节点
            next = node.next;
            // node的指针反转方向
            node.next = prev;
            // 指向下一个节点，继续反转指针
            prev = node;
            node = next;
        }
        return prev;
    }

    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode reverseList0(ListNode head) {
        if (head == null) {
            return head;
        }
        return reverseCore(null, head);
    }
    public ListNode reverseCore(ListNode prev, ListNode node) {
        ListNode next = node.next;
        node.next = prev;
        if (next == null) {
            return node;
        }
        return reverseCore(node, next);
    }
}
