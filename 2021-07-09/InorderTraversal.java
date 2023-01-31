package haiwaitu.t20210709;

import haiwaitu.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2021/07/10 23:45
 * @Description 94. 二叉树的中序遍历
 */
public class InorderTraversal {
     List<Integer> result = new ArrayList<>();
     public List<Integer> inorderTraversal(TreeNode root) {
         // 递归，时间O(N)，空间最坏情况下退化成链表，O(N)
         inorder(root);
         return result;
     }
     public void inorder(TreeNode node) {
         if (node == null) {
             return;
         }
         inorder(node.left);
         result.add(node.val);
         inorder(node.right);
     }

    public List<Integer> inorderTraversal0(TreeNode root) {
        // 迭代，时间O(N)，空间最坏情况下退化为链表，O(N)
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        // 循环继续的两个条件，1、右子节点不为空，2、或者栈里还有需要回溯的上级节点
        while (node != null || !stack.isEmpty() ) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }
}
