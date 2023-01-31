package haiwaitu.t20210712;

import haiwaitu.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2021/07/13 17:11
 * @Description 107. 二叉树的层序遍历 II
 */
public class LevelOrderButtom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // BFS跌打解法
        List<List<Integer>> result = new LinkedList<>();
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
            result.add(0, subList);
        }
        return result;
    }
}
