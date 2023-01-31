package haiwaitu.t20210703;

import haiwaitu.ListNode;

/**
 * @Author huangjunqiao
 * @Date 2021/07/04 11:43
 * @Description 24. 两两交换链表中的节点
 */
public class SwapPairs {
     public ListNode swapPairs(ListNode head) {
         // 递归，每次递归交换两个节点，边界条件需要注意头节点的NPE处理，时间O(N)，空间O(N)
         if (head == null || head.next == null) {
             return head;
         }
         ListNode newHead = head.next;
         head.next = swapPairs(newHead.next);
         newHead.next = head;
         return newHead;
     }

    public ListNode swapPairs0(ListNode head) {
        // 迭代解法，时间O(N)，空间O(1)
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            // 先保存要换到右边的节点的指针
            ListNode left2Right = prev.next;
            // 把节点换到左边
            prev.next = prev.next.next;
            // 要换到右边的节点指向下一轮迭代的左节点
            left2Right.next = prev.next.next;
            // 已经换到左边的节点指向换到右边的节点
            prev.next.next = left2Right;
            // 移动当前节点指针，准备交换下一对节点
            prev = prev.next.next;
        }
        return dummy.next;
    }
}
