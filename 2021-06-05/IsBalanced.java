package haiwaitu.t20210605;

import haiwaitu.TreeNode;

/**
 * @Author huangjunqiao
 * @Date 2021/06/06 15:46
 * @Description 110. 平衡二叉树
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        // 自顶向下递归，递归层数logN，每次递归都要计算当前层的高度，花费O(N)，即平均N*logN，最坏情况退化成链表，N*N。即时间复杂度O(N^2)，同理，空间复杂度最坏O(N)
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 &&
                isBalanced(root.left) && isBalanced(root.right);
    }
    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

     boolean isBalance;
     public boolean isBalanced0(TreeNode root) {
         // 自底向上递归，时间O(N)，空间O(N)
         isBalance = true;
         dfs(root);
         return isBalance;
     }
     public int dfs(TreeNode node) {
         if (node == null) {
             return 0;
         }
         int left = dfs(node.left);
         int right = dfs(node.right);
         if (isBalance && Math.abs(left - right) > 1) {
             isBalance = false;
         }
         return 1 + Math.max(left, right);
     }
}
