package haiwaitu.t20220803;

import haiwaitu.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2022/08/03 17:18
 * @Description 235. 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 两次遍历，时间：O(n)，空间：O(n))
        List<TreeNode> path1 = findPath(root, p);
        List<TreeNode> path2 = findPath(root, q);
        int m = path1.size(), n = path2.size();
        TreeNode res = root;
        for (int i = 0; i < m && i < n; i++) {
            if (path1.get(i).val == path2.get(i).val) {
                res = path1.get(i);
            }
        }
        return res;
    }
    public List<TreeNode> findPath(TreeNode root, TreeNode tar) {
        List<TreeNode> path = new ArrayList<>();
        while (root.val != tar.val) {
            path.add(root);
            if (root.val < tar.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        path.add(tar);
        return path;
    }

    public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
        // 一次遍历，时间：O(n)，空间：O(1)
        while (true) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                return root;
            }
        }
    }
}
