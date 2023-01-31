package haiwaitu.t20210711;

import haiwaitu.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2021/07/12 22:42
 * @Description 145. 二叉树的后序遍历
 */
public class PostorderTraversal {
     List<Integer> result = new ArrayList<>();
     public List<Integer> postorderTraversal(TreeNode root) {
         // 递归，时间O(N)，空间最坏情况下退化成链表，O(N)
         postorder(root);
         return result;
     }

     public void postorder(TreeNode node) {
         if (node == null) {
             return;
         }
         postorder(node.left);
         postorder(node.right);
         result.add(node.val);
     }

    public List<Integer> postorderTraversal0(TreeNode root) {
        // 迭代解法，时间O(N)，空间O(N)
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 两种情况需要处理当前节点并向上回溯：1、右子节点为空，即在向右深度递归的时候到了叶子节点；
            // 2、右子节点不为空，但在上一轮迭代处理过了
            if (root.right == null || prev == root.right) {
                result.add(root.val);
                prev = root;
                // 置为null是为了在下一轮迭代跳过内部的while循环，从栈里弹出父节点
                root = null;
            } else {
                // 如右节点存在，并且还没被处理过，则继续对右节点深度递归
                stack.push(root);
                // 方便下轮迭代对右子节点进行左-右-中的顺序遍历
                root = root.right;
            }
        }
        return result;
    }
}
