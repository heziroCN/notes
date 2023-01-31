package haiwaitu.t20210719;

import haiwaitu.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2021/07/20 23:31
 * @Description 114. 二叉树展开为链表
 */
public class Flatten {
    // public void flatten(TreeNode root) {
    //     // 递归实现DFS中序遍历，时间O(N)，空间O(N)
    //     if (root != null) {
    //         inorder(root);
    //     }
    // }

    // public TreeNode inorder(TreeNode node) {
    //     if (node.left != null) {
    //         // 0、左子节点递归展开
    //         TreeNode origRightPrev = inorder(node.left);
    //         // 1、右子节点拼接到左子节点展开后的right
    //         origRightPrev.right = node.right;
    //         // 2、左子节点移到原来右子节点的位置
    //         node.right = node.left;
    //         // 3、原来的左子节点置为null
    //         node.left = null;
    //         // 4、跳过已处理节点，防止重复处理
    //         node = origRightPrev;
    //     }
    //     if (node.right != null) {
    //         return inorder(node.right);
    //     }
    //     return node;
    // }

    List<TreeNode> preList = new ArrayList<>();
    public void flatten(TreeNode root) {
        // 递归实现DFS前序遍历，时间O(N)，空间O(N)
        preorder(root);
        int size = preList.size();
        TreeNode node = root;
        for (int i = 1; i < size; i++) {
            node.left = null;
            node.right = preList.get(i);
            node = node.right;
        }
    }
    public void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        preList.add(node);
        preorder(node.left);
        preorder(node.right);
    }

     public void flatten0(TreeNode root) {
         // 迭代实现DFS前序遍历，时间O(N)，空间O(N)
         TreeNode prev;
         TreeNode curr = root;
         // 左子节点的最右子节点，在展开成链表后会接在右子节点的前面。
         while (curr != null) {
             while (curr.left != null) {
                 prev = curr.left;
                 // 1、找左节点的最右子节点
                 while (prev.right != null) {
                     prev = prev.right;
                 }
                 // 2、把当前右子节点接到左子节点的最右子节点的右边
                 prev.right = curr.right;
                 // 3、把左子节点移到右子节点
                 curr.right = curr.left;
                 // 4、清空左子节点
                 curr.left = null;
             }
             // 左子树已经接到右子节点了，下轮迭代处理右子节点即可
             curr = curr.right;
         }
     }
}
