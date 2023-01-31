package haiwaitu.t20210606;

import haiwaitu.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/06/07 18:43
 * @Description 111. 二叉树的最小深度
 */
public class MinDepth {
     int min;
     public int minDepth0(TreeNode root) {
         // DFS解法，时间每个节点遍历一次，O(N)；空间为树高，最坏情况退化为链表O(N)
         if (root == null) {
             return 0;
         }
         min = Integer.MAX_VALUE;
         dfs(root, 1);
         return min;
     }
     public void dfs(TreeNode node, int currNum) {
         if (node.left == null && node.right == null && currNum < min) {
             min = currNum;
         }
         if (node.left != null) {
             dfs(node.left, currNum + 1);
         }
         if (node.right != null) {
             dfs(node.right, currNum + 1);
         }
     }
    public int minDepth(TreeNode root) {
        // BFS解法，时间每个节点出入队列一次，O(N)；空间为队列大小，最坏情况完美二叉树，底层N/2个节点，即O(N)
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int currDepth = 0;
        while (!q.isEmpty()) {
            currDepth++;
            int level = q.size();
            for (int i = 0; i < level; i++) {
                TreeNode node = q.poll();
                // 因为是自顶向下的遍历，所以找到第一个叶子节点就可以返回了
                if (node.left == null && node.right == null) {
                    return currDepth;
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return currDepth;
    }
}
