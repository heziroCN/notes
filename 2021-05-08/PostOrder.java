package haiwaitu.t20210508;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2021/05/08 16:13
 * @Description 145. 二叉树的后序遍历
 */
public class PostOrder {

    public static List<Integer> postorderTraversal(TreeNode root) {
        // 迭代解法 关键在于如何保记录右子节点是否已经访问过的状态（节点prev）
        // 以及迭代的时候区分访问的节点是未访问过的，还是从栈里弹出来的
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                result.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }

        return result;
    }
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     // 递归解法
    //     List<Integer> result = new ArrayList<>();
    //     postOrder(root, result);
    //     return result;
    // }
    // public void postOrder(TreeNode node, List<Integer> list) {
    //     if (node == null) {
    //         return;
    //     }
    //     // 先访问左节点
    //     postOrder(node.left, list);
    //     // 然后访问右节点
    //     postOrder(node.right, list);
    //     // 最后才是访问当前节点
    //     list.add(node.val);
    // }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root.right = root2;
        root2.left = root3;

        System.out.println(postorderTraversal(root));
    }
}
