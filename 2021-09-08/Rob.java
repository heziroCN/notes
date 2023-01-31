package haiwaitu.t20210908;

import haiwaitu.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangjunqiao
 * @Date 2021/09/08 08:38
 * @Description 337. 打家劫舍 III
 */
public class Rob {
    // 选中
    Map<TreeNode, Integer> f = new HashMap<>();
    // 不选中
    Map<TreeNode, Integer> g = new HashMap<>();
    public int rob(TreeNode root) {
        // 后续遍历，时间：O(N)，空间：O(N)
        dfs(root);
        return Math.max(f.get(root), g.get(root));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(g.getOrDefault(node.left, 0), f.getOrDefault(node.left, 0)) + Math.max(g.getOrDefault(node.right, 0), f.getOrDefault(node.right, 0)));
    }
}
