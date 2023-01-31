package haiwaitu.t20210628;

import haiwaitu.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2021/06/29 15:51
 * @Description 234. 回文链表
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        // 数组+双指针，时间：O(n)，空间：O(n)
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (list.get(l).val != list.get(r).val) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
     public boolean isPalindrome0(ListNode head) {
         // 反转+快慢指针，时间：O(n)，空间：O(1)
         ListNode mid = findMid(head);
         ListNode head2 = mid;
         head2 = reverse(head2);// 反转并从中点断开
         while (head != null && head2 != null) {
             if (head.val != head2.val) {
                 return false;
             }
             head = head.next;
             head2 = head2.next;
         }
         return true;
     }
     public ListNode reverse(ListNode head) {
         ListNode pre = null, node = head;
         while (node != null) {
             ListNode next = node.next;
             node.next = pre;

             pre = node;
             node = next;
         }
         return pre;
     }
     public ListNode findMid(ListNode head) {
         ListNode slow = head, fast = head;
         while (fast != null && fast.next != null) {
             slow = slow.next;
             fast = fast.next.next;
         }
         return slow;
     }
}
