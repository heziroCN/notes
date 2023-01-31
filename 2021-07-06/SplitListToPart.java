package haiwaitu.t20210706;

import haiwaitu.ListNode;

/**
 * @Author huangjunqiao
 * @Date 2021/07/07 22:10
 * @Description 725. 分隔链表
 */
public class SplitListToPart {
    public ListNode[] splitListToParts(ListNode head, int k) {
        // 时间O(N)，空间不算返回结果O(1)
        if (head == null) {
            return new ListNode[k];
        }
        // 较短子链表和较长子链表长度最多相差1
        int len = getLen(head);
        // 较短的子链表长度
        int subLen = len / k;
        // 较长子链表的数量
        int longerNum = len % k;
        ListNode[] result = new ListNode[k];
        ListNode dummy = new ListNode(0, head);
        for (int i = 0; i < k; i++) {
            // 构造子链表
            ListNode node = dummy;
            for (int j = 0; j < subLen; j++) {
                node = node.next;
            }
            // 如果是前longgerNum个，为较长子链表，需要再增加一个节点。
            if (i < longerNum) {
                node = node.next;
            }
            result[i] = dummy.next;
            // 使dummy永远指向当前链表头
            dummy.next = node.next;
            // 断开
            node.next = null;
        }
        return result;
    }

    public int getLen(ListNode head) {
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}
