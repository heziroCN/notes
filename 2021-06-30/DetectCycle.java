package haiwaitu.t20210630;

import haiwaitu.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author huangjunqiao
 * @Date 2021/07/01 14:33
 * @Description 142. 环形链表 II
 */
public class DetectCycle {
     public ListNode detectCycle(ListNode head) {
         // 哈希表解法，时间O(N)，空间O(N)
         Set<ListNode> set = new HashSet<>();
         ListNode node= head;
         ListNode entrance = null;
         while (node != null) {
             if (!set.contains(node)) {
                 set.add(node);
                 node = node.next;
             } else {
                 entrance = node;
                 break;
             }
         }
         return entrance;
     }

    /**
     * fast走f步，slow走s步，相遇时fast比slow多走n圈，f=2s=s+nb，得s=nb
     * a为链表尾到环入口距离，所有入环点为a+nb，slow只需再走a步可到入环点
     */
    public ListNode detectCycle0(ListNode head) {
        // 快慢指针解法，时间O(N)，空间O(1)
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next, fast = head.next.next;
        while (slow != fast) {
            // fast走到尽头，说明链表没环，提前返回
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        // 链表有环，则寻找入口点
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
