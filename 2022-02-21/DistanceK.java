package haiwaitu.t20220221;

import haiwaitu.TreeNode;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2022/02/22 18:19
 * @Description 863. 二叉树中所有距离为 K 的结点
 */
public class DistanceK {
    Map<TreeNode, TreeNode> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    // 时间：O(n)，空间：O(n)
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParent(root);
        dfs(target, null, 0, k);
        return res;
    }
    public void findParent(TreeNode node) {
        if (node.left != null) {
            map.put(node.left, node);
            findParent(node.left);
        }
        if (node.right != null) {
            map.put(node.right, node);
            findParent(node.right);
        }
    }
    public void dfs(TreeNode node, TreeNode from, int dist, int k) {
        if (node == null) {
            return;
        }
        if (dist == k) {
            res.add(node.val);
            return;
        }
        if (node.left != from) {
            dfs(node.left, node, dist + 1, k);
        }
        if (node.right != from) {
            dfs(node.right, node, dist + 1, k);
        }
        if (map.get(node) != from) {
            dfs(map.get(node), node, dist + 1, k);
        }
    }
}
