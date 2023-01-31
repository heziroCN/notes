package haiwaitu.t20210628;

import haiwaitu.ListNode;

/**
 * @Author huangjunqiao
 * @Date 2021/06/29 12:58
 * @Description 148. 排序链表
 */
public class SortList {
    public static ListNode sortList(ListNode head) {
        // 自顶向下归并，时间O(NlogN)，空间O(logN)
        // tail初始化为null，一是可以在处理在0.的边界情况；二是简洁代码，不需要在主函数再写一次找尾结点的循环
        return sortCore(head, null);
    }
    public static ListNode sortCore(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        // 0.因为sortListCore递归的时候取了两个闭区间，[4,2,1,3]拆分后变成[4,2][2,1][1,3]，所以需要在递归底层（即两个节点）的时候将重复的节点去掉（head.next置为null）。
        // 无论链表长度为奇数还是偶数，最终都会到达两个节点的状态，如[4,2,1,3]，第一次拆分后变成[4,2,1]和[1,3]；若长度为3，如[4,2,1]拆分后变成[4,2]和[2,1]；
        // 得到规律：长度为2的相邻区间之间，必然有一个数字重复出现。边界情况：结尾的节点会被置为null不会漏掉，因为初始化的时候tail传入的就是null
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        // 1.找到链表中点(偏右)
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            // 为了保证长度为奇数时，fast也能走到tail，只能在循环内进行这个判断
            if (fast != tail) {
                fast = fast.next;
            }
        }
        // 2.对两个链表递归排序
        ListNode mid = slow;
        ListNode head1 = sortCore(head, mid);
        ListNode head2 = sortCore(mid, tail);
        // 3.合并排好序的两个链表，返回
        return merge(head1, head2);
    }
    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy, node1 = head1, node2 = head2;
        while (node1 != null && node2 != null) {
            if (node2.val < node1.val) {
                node.next = node2;
                node2 = node2.next;
            } else {
                node.next = node1;
                node1 = node1.next;
            }
            node = node.next;
        }
        if (node2 != null) {
            node.next = node2;
        } else {
            node.next = node1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        sortList(head);
    }
}
