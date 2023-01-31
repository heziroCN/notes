package haiwaitu.t20210703;

import haiwaitu.ListNode;

/**
 * @Author huangjunqiao
 * @Date 2021/07/04 12:21
 * @Description 328. 奇偶链表
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        // 时间O(N)，空间O(1)
        if (head == null) {
            return head;
        }
        ListNode odd = head, even = head.next;
        ListNode evenHead = even;
        // 边界需要考虑清楚，even!=null处理的是奇数长度的边界情况，even.next!=null处理的是偶数长度的边界情况
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            odd.next = even;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
