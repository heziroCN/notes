package haiwaitu.t20210530;

import haiwaitu.TreeNode;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/05/30 17:26
 * @Description 106. 从中序与后序遍历序列构造二叉树
 */
public class BuildTreePost {
    Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 递归，时间O(N)，空间O(N)
        int len = inorder.length;
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildCore(inorder, 0, len - 1, postorder, 0, len - 1);
    }
    public TreeNode buildCore(int[] inorder, int inL, int inR, int[] post, int postL, int postR) {
        if (inL > inR || postL > postR) {
            return null;
        }
        // 1、后序遍历区间内最后一个元素为根节点，找到根节点在中序遍历中的位置inorderIdx。
        int val = post[postR];
        int inorderIdx = indexMap.get(val);
        // 2、inorderIdx到中序遍历左边界的距离，即左子树的节点数leftNum。根据leftNum找到后序遍历数组中左右子树的分界线。
        int leftNum = inorderIdx - inL;
        TreeNode node = new TreeNode(val);
        node.left = buildCore(inorder, inL, inorderIdx - 1, post, postL, postL + leftNum - 1);
        node.right = buildCore(inorder, inorderIdx + 1, inR, post, postL + leftNum, postR - 1);
        return node;
    }

}
