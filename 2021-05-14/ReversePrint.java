package haiwaitu.t20210514;

/**
 * @Author huangjunqiao
 * @Date 2021/05/15 22:33
 * @Description
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        int[] result = new int[len];
        // 递归解法 时间O(n)，扫描了两遍链表 空间O(n)，用到了递归调用栈深度
        // recursive(head, result, len - 1);
        // 迭代解法 时间O(n)，扫描了两遍链表 空间O(1)
        for (int i = len - 1; i >= 0; i--) {
            result[i] = head.val;
            head = head.next;
        }
        return result;
    }
    public void recursive(ListNode node, int[] result, int idx) {
        if (node == null) {
            return;
        }
        recursive(node.next, result, idx - 1);
        result[idx] = node.val;
    }
}
