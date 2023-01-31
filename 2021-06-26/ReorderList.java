package haiwaitu.t20210626;

import haiwaitu.ListNode;

import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/06/27 11:02
 * @Description 143. 重排链表
 */
public class ReorderList {
    public static void reorderList(ListNode head) {
        // 双指针，两个指针分别指向链表头尾，将尾部节点插入链表头部，时间O(N)，空间O(N)
        ListNode node = head;
        LinkedList<ListNode> stack = new LinkedList<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        ListNode l = head;
        while (l != stack.peek() && l.next != stack.peek()) {
            ListNode r = stack.poll();
            // 断开左节点
            ListNode lNext = l.next;
            // 接上栈顶节点
            l.next = r;
            // 断开右节点并接上原来的左节点
            r.next = lNext;
            l = lNext;
        }
    }

    public static void reorderList0(ListNode head) {
        // 逆序后半部分链表再合并，考察对问题的分解能力，时间O(N)，空间O(1)
        ListNode midPrev = findMiddlePrev(head);
        // 在中点处断开
        ListNode mid = midPrev.next;
        midPrev.next = null;
        // 反转链表后半段
        ListNode reverseHead = reverse(mid);
        // 合并两个链表
        merge(head, reverseHead);
    }

    public static ListNode findMiddlePrev(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static ListNode reverse(ListNode head) {
        ListNode node = head, prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;

            prev = node;
            node = next;
        }
        return prev;
    }
    public static void merge(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            ListNode origNext1 = head1.next;
            head1.next = head2;

            ListNode origNext2 = head2.next;
            head2.next = origNext1;

            head2 = origNext2;
            head1 = origNext1;
        }
    }

}
