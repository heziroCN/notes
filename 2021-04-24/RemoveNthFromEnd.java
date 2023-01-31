package haiwaitu.t20210424;

import haiwaitu.ListNode;

/**
 * @Author huangjunqiao
 * @Date 2021/04/24 17:05
 * @Description 19. 删除链表的倒数第 N 个结点
 */
public class RemoveNthFromEnd {
    /**
     * 删除倒数第N个节点，两趟扫描可以很容易的实现，但是属于暴力解法
     * 要实现一趟扫描，可以通过栈"后进先出"的特性实现，但是需要O(n)的空间
     * 更优雅的解法是快慢指针，只需要O(1)的空间。其中一个指针先走n步，
     * 因为是删除操作，需要记录待删除节点的前驱节点。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 快慢指针，时间O(N)，空间O(1)
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // do delete
        slow.next = slow.next.next;
        return dummy.next;
    }
}
