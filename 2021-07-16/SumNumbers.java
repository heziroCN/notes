package haiwaitu.t20210716;

import haiwaitu.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/07/17 23:34
 * @Description 129. 求根节点到叶节点数字之和
 */
public class SumNumbers {
     public int sumNumbers(TreeNode root) {
         // DFS前序遍历，时间O(N)，空间O(N)
         return dfs(root, 0);
     }
     public int dfs(TreeNode node, int currSum) {
         if (node == null) {
             return 0;
         }
         currSum = currSum * 10 + node.val;
         if (node.left == null && node.right == null) {
             return currSum;
         }
         return dfs(node.left, currSum) + dfs(node.right, currSum);
     }

    public int sumNumbers0(TreeNode root) {
        // BFS，用两个队列分别存储节点和总和，一层层累加，到叶子节点统计，时间O(N)，空间O(N)
        int sum = 0;
        if (root == null) {
            return sum;
        }
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        Deque<Integer> valQueue = new LinkedList<>();
        nodeQueue.offer(root);
        valQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = nodeQueue.poll();
                int val = valQueue.poll();
                if (node.left == null && node.right == null) {
                    sum += val;
                }
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    valQueue.offer(val * 10 + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    valQueue.offer(val * 10 + node.right.val);
                }
            }
        }
        return sum;
    }
}
