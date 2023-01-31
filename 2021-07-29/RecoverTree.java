package haiwaitu.t20210729;

import haiwaitu.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2021/07/30 16:31
 * @Description 99. 恢复二叉搜索树
 */
public class RecoverTree {
    List<TreeNode> list = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        // 借助数组存储中序遍历结果，时间O(N)，空间O(N)
        // 1、中序遍历，并把遍历结果顺序填入数组中
        inorder(root);
        // 2、在数组中找到逆序的两个节点值
        TreeNode small = null, big = null;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val) {
                small = list.get(i + 1);
                if (big == null) {
                    big = list.get(i);
                } else {
                    break;
                }
            }
        }
        // 3、两个节点的值
        swapVal(small, big);
    }
    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        list.add(node);
        inorder(node.right);
    }

    public void swapVal(TreeNode p, TreeNode q) {
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }
    public void recoverTree0(TreeNode root) {
        // 不借助数组的中序遍历，时间O(N)，空间平均O(H)，最坏O(N)
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        TreeNode pre = null, small = null, big = null;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (pre != null && pre.val > curr.val) {
                small = curr;
                if (big == null) {
                    // big为null，说明当前找到的是第一个错位数
                    big = pre;
                } else {
                    // big非null，说明当前找到的是第二个错位数
                    break;
                }
            }
            pre = curr;
            curr = curr.right;
        }
        swapVal(small, big);
    }

    TreeNode n1, n2, pre;
    public void recoverTree1(TreeNode root) {
        // Morris遍历，时间：O(n)，空间：O(1)
        while (root != null) {
            if (root.left != null) {
                TreeNode rightMost = root.left;
                while (rightMost.right != null && rightMost.right != root) {
                    rightMost = rightMost.right;
                }
                if (rightMost.right != root) {
                    rightMost.right = root;
                    root = root.left;
                } else {
                    handle(root);
                    rightMost.right = null;
                    pre = root;
                    root = root.right;
                }
            } else {
                handle(root);
                pre = root;
                root = root.right;
            }
        }
        swapVal(n1, n2);
    }
    public void handle(TreeNode root) {
        if (pre != null && pre.val > root.val) {
            if (n1 == null) {
                n1 = pre;
            }
            n2 = root;
        }
    }
}
