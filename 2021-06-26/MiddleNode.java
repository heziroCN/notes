package haiwaitu.t20210626;

import haiwaitu.ListNode;

/**
 * @Author huangjunqiao
 * @Date 2021/06/27 12:26
 * @Description 876. 链表的中间结点
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        // 快慢指针，时间O(N)，空间O(1)
        ListNode slow = head, fast = head;
        // 快指针每次走两步，两个空指针都必须在循环条件判断，如果在循环内判断另一个空指针，当长度为奇数时，fast节点会在某次循环结束时走到尾节点，此时slow走到了唯一的中点，循环还能继续进行一次，出现slow走过头的错误。
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
