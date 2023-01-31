package haiwaitu.t20210423;

/**
 * @Author huangjunqiao
 * @Date 2021/04/23 12:29
 * @Description
 */
public class MergeTwoLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultIdx = new ListNode(0);
        ListNode resultHead = resultIdx;
        while (l1 != null && l2 != null) {
            // 比较l1和l2的大小，按顺序放进合并的链表里
            if (l1.val < l2.val) {
                resultIdx.next = l1;
                l1 = l1.next;
            } else {
                resultIdx.next = l2;
                l2 = l2.next;
            }
            resultIdx = resultIdx.next;
        }
        // 其中一个链表的节点都处理完之后，处理另一个链表的剩余节点
        if (l1 == null) {
            resultIdx.next = l2;
        } else if (l2 == null) {
            resultIdx.next = l1;
        }
        return resultHead.next;
    }
}
