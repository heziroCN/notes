package haiwaitu.t20210604;

import haiwaitu.TreeNode;

/**
 * @Author huangjunqiao
 * @Date 2021/06/05 17:06
 * @Description 543. 二叉树的直径
 */
public class DiameterOfBinaryTree {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        // dfs，时间O(N)，空间O(logN)
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        // left+right恰好为直径长度
        ans = Math.max(ans, left + right);
        return 1 + Math.max(left, right);
    }
}
