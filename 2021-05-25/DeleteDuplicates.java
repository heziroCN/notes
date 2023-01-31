package haiwaitu.t20210525;
import haiwaitu.ListNode;

/**
 * @Author huangjunqiao
 * @Date 2021/05/25 15:26
 * @Description 83. 删除排序链表中的重复元素
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        // 时间O(n)，空间O(1)
        if (head == null) {
            return head;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
