package haiwaitu.t20210604;

import haiwaitu.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/06/05 16:46
 * @Description 226. 翻转二叉树
 */
public class InvertTree {
    public TreeNode invertTree0(TreeNode root) {
        // 递归解法，时间O(N)，空间O(logN)
        invertCore(root);
        return root;
    }
    void invertCore(TreeNode node) {
        if (node == null) {
            return;
        }
        // 交换左右节点
        exchange(node);
        invertCore(node.left);
        invertCore(node.right);
    }

    public void exchange(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public TreeNode invertTree(TreeNode root) {
        // 迭代解法，时间O(N)，空间O(N)，完美二叉树有N/2个叶子节点
        if (root == null) {
            return root;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            // 交换左右节点
            exchange(node);
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        return root;
    }
}
