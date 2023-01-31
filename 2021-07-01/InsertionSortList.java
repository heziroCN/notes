package haiwaitu.t20210701;

import haiwaitu.ListNode;

/**
 * @Author huangjunqiao
 * @Date 2021/07/02 10:58
 * @Description 147. 对链表进行插入排序
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        // 时间O(N^2)，空间O(1)
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        // node指向当前待排序的节点
        ListNode node = head.next, lastSorted = head;
        while (node != null) {
            if (node.val > lastSorted.val) {
                // 无需调整顺序，lastSorted向后移动即可
                lastSorted = lastSorted.next;
            } else {
                // 从头开始遍历，把node插入到恰好比node大的位置之前
                ListNode insertPos = dummy;
                while (insertPos.next.val < node.val) {
                    insertPos = insertPos.next;
                }
                // 直接修改指针指向，比断开再插入的操作次数少
                lastSorted.next = node.next;
                node.next = insertPos.next;
                insertPos.next = node;
            }
            // 每次循环lastSorted指向的位置都会改变，直接使用它更新当前指针
            node = lastSorted.next;
        }
        return dummy.next;
    }
}
