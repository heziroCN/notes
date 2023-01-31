package haiwaitu.t20210523;

/**
 * @Author huangjunqiao
 * @Date 2021/05/23 18:02
 * @Description 124. 二叉树中的最大路径和
 */

public class MaxPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // 递归解法，时间复杂度O(N)，每个节点最多访问一次。空间复杂度O(N)，递归调用层数、即树的高度（最坏树高为N）
        maxCore(root);
        return max;
    }
    public int maxCore(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 子树贡献为负数的情况，需要改为0
        int leftGain = Math.max(maxCore(node.left), 0);
        int rightGain = Math.max(maxCore(node.right), 0);

        int currentMax = node.val + leftGain + rightGain;
        max = Math.max(currentMax, max);
        return node.val + Math.max(leftGain, rightGain);
    }
}
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
