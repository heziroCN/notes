package haiwaitu.t20210602;

import haiwaitu.TreeNode;

import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/06/03 22:42
 * @Description 104. 二叉树的最大深度
 */
public class MaxDepth {
     public int maxDepth0(TreeNode root) {
         // dfs，时间复杂度O(N)，每个节点都遍历一次。空间复杂度O(logN)，递归栈深度取决于树高
         if (root == null) {
             return 0;
         }
         int leftDepth = 1 + maxDepth(root.left);
         int rightDepth = 1 + maxDepth(root.right);
         return Math.max(leftDepth, rightDepth);
     }

    public int maxDepth(TreeNode root) {
        // bfs，时间复杂度O(N)，空间复杂度为O(N)，最坏情况下完美二叉树，底层节点数量达N/2。
        if (root == null) {
            return 0;
        }
        int max = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            int width = queue.size();
            for (int i = 0; i < width; i++) {
                node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            max++;
        }
        return max;
    }
}
