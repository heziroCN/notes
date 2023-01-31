package haiwaitu.t20211126;

import haiwaitu.TreeNode;

/**
 * @Author huangjunqiao
 * @Date 2021/11/26 23:13
 * @Description 700. 二叉搜索树中的搜索
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        // 时间：O(logN)，空间：O(1)
        TreeNode res = null, node = root;
        while (node != null) {
            if (node.val > val) {
                node = node.left;
            } else if (node.val < val) {
                node = node.right;
            } else {
                res = node;
                break;
            }
        }
        return res;
    }
}
