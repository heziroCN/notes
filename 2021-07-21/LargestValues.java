package haiwaitu.t20210721;

import haiwaitu.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2021/07/22 01:13
 * @Description 515. 在每个树行中找最大值
 */
public class LargestValues {
     public List<Integer> largestValues(TreeNode root) {
         // BFS，遍历每层的时候，保存最大值即可。时间O(N)，空间O(N)
         List<Integer> result = new ArrayList<>();
         if (root == null) {
             return result;
         }
         Deque<TreeNode> q = new LinkedList<>();
         q.offer(root);
         while (!q.isEmpty()) {
             int size = q.size();
             int max = q.peek().val;
             for (int i = 0; i < size; i++) {
                 TreeNode node = q.poll();
                 max = Math.max(max, node.val);
                 if (node.left != null) {
                     q.offer(node.left);
                 }
                 if (node.right != null) {
                     q.offer(node.right);
                 }
             }
             result.add(max);
         }
         return result;
     }

    List<Integer> result = new ArrayList<>();
    public List<Integer> largestValues0(TreeNode root) {
        // DFS，使用列表保存每层的最大值，并在DFS过程中更新，时间O(N)，空间O(N)
        dfs(root, 0);
        return result;
    }
    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        // 来到新的一层，需要先添加结果集，防止访问的时候越界
        if (depth >= result.size()) {
            result.add(node.val);
        }
        // 如果比当前最大值大，则更新最大值
        if (node.val > result.get(depth)) {
            result.set(depth, node.val);
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
