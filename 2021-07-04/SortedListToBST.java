package haiwaitu.t20210704;

import haiwaitu.ListNode;
import haiwaitu.TreeNode;

/**
 * @Author huangjunqiao
 * @Date 2021/07/05 17:13
 * @Description 109. 有序链表转换二叉搜索树
 */
public class SortedListToBST {
     public TreeNode sortedListToBST0(ListNode head) {
         // 分治解法，时间O(NlogN)；空间 由于树平衡，不会退化成链表，最坏情况也是O(logN)
         // 右节点初始化为null有两个好处：1、编码方便，2、长度+1，后续递归可以采用左闭右开区间的策略，左闭右开区间主要是方便单向链表递归 ，如：[left, mid],[mid.next,right]，不会造成mid节点重复处理
         return buildTree(head, null);
     }
     public TreeNode buildTree(ListNode l, ListNode r) {
         if (l == r) {
             return null;
         }
         // 找区间中点(由于初始化对链表长度+1，这里的中点偏右)
         ListNode mid = findMiddle(l, r);
         TreeNode curr = new TreeNode(mid.val);

         curr.left = buildTree(l, mid);
         curr.right = buildTree(mid.next, r);
         return curr;
     }
     public ListNode findMiddle(ListNode l, ListNode r) {
         ListNode slow = l, fast = l;
         while (fast != r && fast.next != r) {
             slow = slow.next;
             fast = fast.next.next;
         }
         return slow;
     }

    ListNode globalHead;
    public TreeNode sortedListToBST(ListNode head) {
        // 分治+中序遍历，升序链表正好和二叉搜索树的中序遍历结果一致。时间O(N)，空间O(logN)
        globalHead = head;
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        return buildTreeInOrder(0, len - 1);
    }

    public TreeNode buildTreeInOrder(int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;

        TreeNode left = buildTreeInOrder(l, mid - 1);
        TreeNode curr = new TreeNode(globalHead.val);
        // 创建完节点后移动链表指针
        globalHead = globalHead.next;
        TreeNode right = buildTreeInOrder(mid + 1, r);

        curr.left = left;
        curr.right = right;
        return curr;
    }


}
