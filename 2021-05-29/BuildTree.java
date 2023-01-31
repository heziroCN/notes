package haiwaitu.t20210529;

import haiwaitu.TreeNode;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/05/29 18:22
 * @Description 105. 从前序与中序遍历序列构造二叉树
 */
public class BuildTree {
    Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 使用HashMap优化的递归，时间O(N)，空间O(N)
        int len = preorder.length;
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildCore(preorder, 0, len - 1, inorder, 0, len - 1);
    }
    /**
     * 递归过程主要做两件事：1、根据前序遍历头节点（当前节点）找到其在中序遍历数组中的位置
     * 2、根据第1步位置，计算中序遍历左/右节点的数量，找到前序遍历中左右子节点的分界线，以继续下一轮递归
     */
    public TreeNode buildCore(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        int val = preorder[preL];
        TreeNode node = new TreeNode(val);
        // 1、查找目标值在中序遍历数组的位置
        int inorderIdx = indexMap.get(val);
        // 2、结算中序遍历中当前节点左边的节点数量
        int leftNum = inorderIdx - inL;
        node.left = buildCore(preorder, preL + 1, preL + leftNum, inorder, inL, inorderIdx - 1);
        node.right = buildCore(preorder, preL + leftNum + 1, preR, inorder, inorderIdx + 1, inR);
        return node;
    }
}
