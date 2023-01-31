package haiwaitu.t20210711;

import haiwaitu.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2021/07/12 23:03
 * @Description 102. 二叉树的层序遍历
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // BFS，时间：O(N)，空间：最坏情况下完美二叉树，底层有N/2个节点，O(N)
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                subList.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            result.add(subList);
        }
        return result;
    }
}
