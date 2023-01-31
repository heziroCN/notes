package haiwaitu.t20210718;

import haiwaitu.TreeNode;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/07/19 22:29
 * @Description 199. 二叉树的右视图
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        // BFS，每次将层序遍历最后一个节点添加到结果集，时间O(N)，空间O(N)
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                if (i == levelSize - 1) {
                    result.add(node.val);
                }
            }
        }
        return result;
    }

    Set<Integer> visited = new HashSet<>();
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView0(TreeNode root) {
        // 先访问右节点的DFS，时间O(N)，空间O(N)
        dfs(root, 0);
        return result;
    }
    public void dfs(TreeNode node, int currDepth) {
        if (node == null) {
            return;
        }
        // 由于递归过程先访问右节点，因此每到新的一层，第一个访问的都最右边的节点
        if (!visited.contains(currDepth)) {
            visited.add(currDepth);
            result.add(node.val);
        }
        dfs(node.right, currDepth + 1);
        dfs(node.left, currDepth + 1);
    }
}
