package haiwaitu.t20210531;

import haiwaitu.TreeNode;

/**
 * @Author huangjunqiao
 * @Date 2021/06/01 14:37
 * @Description 114. 二叉树展开为链表
 */
public class Flatten {
    public void flatten(TreeNode root) {
        // 递归版寻找前驱节点，时间：O(n)，空间：O(n)
        if (root == null) {
            return;
        }
        dfs(root);
    }
    public TreeNode dfs(TreeNode node) {// 返回展开后的最后一个节点
        if (node.left != null) {
            TreeNode origRight = node.right;
            node.right = node.left;
            node.left = null;
            TreeNode flatten = dfs(node.right);
            flatten.right = origRight;
            node = flatten;
        }
        if (node.right != null) {
            node = dfs(node.right);
        }
        return node;
    }

    public void flatten0(TreeNode root) {
        // 迭代版寻找前驱节点，时间：O(n)，空间：O(1)
        TreeNode pre = null;
        while (root != null) {
            TreeNode left = root.left;
            if (left != null) {
                while (left.right != null) {
                    left = left.right;
                }
                left.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
