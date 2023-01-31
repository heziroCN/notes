package haiwaitu.t20210527;

import haiwaitu.TreeNode;

/**
 * @Author huangjunqiao
 * @Date 2021/05/27 18:30
 * @Description 108. 将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        // 输入数组为中序遍历结果，数组中点为根节点，以此类推
        // 每一个二分区间代表一颗子树，区间中点就是当前子树的根节点
        TreeNode root = buildCore(0, nums.length - 1, nums);
        return root;
    }
    public TreeNode buildCore(int l, int r, int[] nums) {
        if (l > r) {
            return null;
        }
        // 选偏小的节点作为父节点，那么偏大的数需要设为右子节点
        int mid = (l + r) >> 1;
        // // 如果选偏大的节点作为父节点，那么偏小的数需要设为左子节点
        // int mid = (l + r + 1) >> 1;
        TreeNode node = new TreeNode(nums[mid]);
        TreeNode lChild = buildCore(l, mid - 1, nums);
        TreeNode rChild = buildCore(mid + 1, r, nums);
        node.left = lChild;
        node.right = rChild;
        return node;
    }
}
