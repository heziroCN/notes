package haiwaitu.t20210714;

import haiwaitu.TreeNode;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/07/15 19:02
 * @Description 113. 路径总和 II
 */
public class PathSum {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> stack = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // DFS前序遍历（从上往下遍历，方便计算），时间O(N^2)，空间O(N)
        dfs(root, targetSum);
        return result;
    }
    public void dfs(TreeNode node, int targetSum) {
        if (node == null) {
            return;
        }
        // 使用栈记录当前路径
        targetSum -= node.val;
        stack.offer(node.val);
        if (targetSum == 0 && node.left == null && node.right == null) {
            result.add(new LinkedList<>(stack));
        }
        dfs(node.left, targetSum);
        dfs(node.right, targetSum);
        stack.pollLast();
    }

    Map<TreeNode, TreeNode> pathMap = new HashMap<>();
    public List<List<Integer>> pathSum0(TreeNode root, int targetSum) {
        // BFS，使用两个队列分别存储节点和当前总和，使用哈希表存储子节点和父节点的映射，实现找到叶子到根节点的路径，时间O(N^2)，空间O(N)
        if (root == null) {
            return result;
        }
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        Deque<Integer> sumQueue = new LinkedList<>();
        nodeQueue.offer(root);
        sumQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = nodeQueue.poll();
                int sum = sumQueue.poll();
                if (sum == targetSum && node.left == null && node.right == null) {
                    result.add(getPath(node));
                }
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    sumQueue.offer(sum + node.left.val);
                    pathMap.put(node.left, node);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    sumQueue.offer(sum + node.right.val);
                    pathMap.put(node.right, node);
                }
            }
        }
        return result;
    }

    public List<Integer> getPath(TreeNode node) {
        List<Integer> list = new LinkedList<>();
        while (node != null) {
            list.add(0, node.val);
            node = pathMap.get(node);
        }
        return list;
    }
}
