package haiwaitu.t20210516;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author huangjunqiao
 * @Date 2021/05/17 17:43
 * @Description 257. 二叉树的所有路径
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
}
public class BinaryTreePaths {
    public List<String> binaryTreePaths0(TreeNode root) {
        // DFS
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, result, root.val + "");
        return result;
    }
    public void dfs(TreeNode node, List<String> list, String str) {
        if (node.left == null && node.right == null) {
            list.add(str);
            return;
        }
        if (node.left != null) {
            String leftStr = str + "->" + node.left.val;
            dfs(node.left, list, leftStr);
        }
        if (node.right != null) {
            String leftStr = str + "->" + node.right.val;
            dfs(node.right, list, leftStr);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        // BFS
        List<String> list = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        if (root == null) {
            return list;
        }
        nodeQueue.offer(root);
        pathQueue.offer(root.val + "");
        // 节点队列和路径队列同步添加删除，只需判断其中一个有没元素就可以了
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();
            if (node.left == null && node.right == null) {
                list.add(path);
            }
            if (node.left != null) {
                nodeQueue.offer(node.left);
                pathQueue.offer(new StringBuilder(path).append("->").append(node.left.val).toString());
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                pathQueue.offer(new StringBuilder(path).append("->").append(node.right.val).toString());
            }
        }
        return list;
    }
}
