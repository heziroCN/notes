package haiwaitu.t20210606;

import haiwaitu.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/06/07 17:21
 * @Description 112. 路径总和
 */
public class HasPathSum {
    public boolean hasPathSum0(TreeNode root, int targetSum) {
        // DFS解法，时间每个节点访问一次O(N)，空间为树高，平均情况下O(logN)，最坏情况退化成链表O(N)
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        // BFS解法，时间每个节点进出队列一次O(N)，空间为队列大小，最坏情况完美二叉树底层有N/2个节点，即O(N)
        if (root == null) {
            return false;
        }
        Deque<TreeNode> q = new LinkedList<>();
        Deque<Integer> valQueue = new LinkedList<>();
        q.offer(root);
        valQueue.offer(root.val);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int currSum = valQueue.poll();
            // 发现叶子节点，判断当前路径和是否等于目标和，否则继续遍历
            if (node.left == null && node.right == null && currSum == targetSum) {
                return true;
            }
            if (node.left != null) {
                q.offer(node.left);
                valQueue.offer(currSum + node.left.val);
            }
            if (node.right != null) {
                q.offer(node.right);
                valQueue.offer(currSum + node.right.val);
            }
        }
        return false;
    }
}
