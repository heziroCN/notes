package haiwaitu.t20210513;

/**
 * @Author huangjunqiao
 * @Date 2021/05/14 11:24
 * @Description 2. 两数相加
 */
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 因为链表逆序，直接从头开始遍历两链表，逐位相加，有进位
        // 则记录并在下一次迭代加上即可。由于两链表的每个节点都只
        // 需要访问一次，所以时间O(N+M)；只用到了指针，空间O(1)
        int carry = 0;
        // 使用辅助节点方便访问
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        while (l1 != null || l2 != null) {
            int num = carry;
            if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num += l2.val;
                l2 = l2.next;
            }
            carry = num / 10;
            result.next = new ListNode(num % 10);
            result = result.next;
        }
        if (carry != 0) {
            result.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
