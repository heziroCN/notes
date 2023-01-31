package haiwaitu.t20210422;

/**
 * @Author huangjunqiao
 * @Date 2021/04/22 15:34
 * @Description 141. 环形链表
 */
public class HasCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    /**
     * 快慢指针，时间O(n)，两个指针遍历整个链表
     * 空间O（1），两个指针占用常数级空间
     * 证明：可以通过数学归纳法，把问题看做快指针追赶慢指针，设k为两指针之间的距离
     * k=1，下一回合快指针走两步，慢指针走一步，两者相遇
     * k=2，下一回合快指针走两步，慢指针走一步，与k=1的情况重合
     * ...
     * k=n，下一回合快指针走两步，慢指针走一步，与k=n-1的情况重合
     * 快指针一回合走3，4，5步也可以，但是走2步能令两指针以最快的速度相遇
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return false;
    }
}
