package haiwaitu.t20220512;

import haiwaitu.TreeNode;

/**
 * @Author huangjunqiao
 * @Date 2022/05/12 21:30
 * @Description 1448. 统计二叉树中好节点的数目
 */
public class GoodNodes {
    int res = 0;
    public int goodNodes(TreeNode root) {
        // 时间：O(n)，空间：调用栈O(n)
        dfs(root, Integer.MIN_VALUE);
        return res;
    }
    public void dfs(TreeNode node, int max) {
        if (node == null) {
            return;
        }
        if (max <= node.val) {
            res++;
        }
        max = Math.max(max, node.val);
        dfs(node.left, max);
        dfs(node.right, max);
    }
}
