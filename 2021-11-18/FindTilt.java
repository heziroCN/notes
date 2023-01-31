package haiwaitu.t20211118;

import haiwaitu.TreeNode;

/**
 * @Author huangjunqiao
 * @Date 2021/11/19 00:25
 * @Description 563. 二叉树的坡度
 */
public class FindTilt {
    int res = 0;
    public int findTilt(TreeNode root) {
        // 时间：O(N)，空间：O(N)
        dfs(root);
        return res;
    }
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = dfs(node.left);
        int r = dfs(node.right);
        res += Math.abs(l - r);
        return l + r + node.val;
    }
}
