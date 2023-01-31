package haiwaitu.t20210723;

import haiwaitu.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/07/24 11:40
 * @Description 98. 验证二叉搜索树
 */
public class IsValidBST {
     public boolean isValidBST(TreeNode root) {
         // 前序遍历递归，每次更新上界和下界，时间O(N)，空间平均O(logN)，最坏情况退化成链表O(N)
         return isBSTCore(root, Long.MIN_VALUE, Long.MAX_VALUE);
     }
     public boolean isBSTCore(TreeNode node, long lower, long upper) {
         if (node == null) {
             return true;
         }
         if (node.val <= lower || node.val >= upper) {
             return false;
         }
         return isBSTCore(node.left, lower, node.val)
         && isBSTCore(node.right, node.val, upper);
     }

    public boolean isValidBST0(TreeNode root) {
        // 中序遍历，时间O(N)，空间O(N)
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        long pre = Long.MIN_VALUE;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            // BST中序遍历前一个值严格小于后面的值
            if (pre >= node.val) {
                return false;
            }
            pre = node.val;
            node = node.right;
        }
        return true;
    }
}
