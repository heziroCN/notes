package haiwaitu.t20210607;

import haiwaitu.TreeNode;

/**
 * @Author huangjunqiao
 * @Date 2021/06/08 18:06
 * @Description 222. 完全二叉树的节点个数
 */
public class CountNodes {
    public static int countNodes(TreeNode root) {
        // 二分解法，假设根节点在第0层，最大层数为h，则节点数在[2^h, 2^(h+1) - 1]内
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        // 二分查找，如果第mid个节点存在，那么节点个数一定大于等于mid，如不存在，节点个数一定小于mid
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (low + high + 1) >> 1;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    public static boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}
