package haiwaitu.t20210624;

import haiwaitu.ListNode;

/**
 * @Author huangjunqiao
 * @Date 2021/06/25 11:27
 * @Description 82. 删除排序链表中的重复元素 II
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        // 时间O(N)，空间O(1)，类似题目83. 删除排序链表中的重复元素，不同的是，需要删除所有重复了的数字，因此，遇到重复数字的时候，可以用一个变量repeat记录当前重复的数字，
        // 如果next指向的数字等于repeat，则删除。直到next指向数不再等于repeat为止。需要注意的是，头节点也可能是重复元素，为了代码更简洁，用dummy节点指向头节点。
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (node.next != null && node.next.next != null) {
            if (node.next.val != node.next.next.val) {
                node = node.next;
            } else {
                int repeat = node.next.val;
                while (node.next != null && node.next.val == repeat) {
                    node.next = node.next.next;
                }
            }
        }
        return dummy.next;
    }
}
