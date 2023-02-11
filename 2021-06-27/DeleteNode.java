package zlt20210627;

import zlListNode;

/**
 * @Author heziro
 * @Date 2021/06/28 12:04
 * @Description 237. 删除链表中的节点
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        // 时间O(1)，空间O(1)
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
