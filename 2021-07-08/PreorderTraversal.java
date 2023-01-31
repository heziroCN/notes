package haiwaitu.t20210708;

import haiwaitu.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2021/07/09 23:49
 * @Description 144. 二叉树的前序遍历
 */
public class PreorderTraversal {
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        // 递归解法，时间O(N)，空间最坏情况下退化成链表，O(N)
        preorder(root);
        return result;
    }
    public void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        preorder(node.left);
        preorder(node.right);
    }

    public List<Integer> preorderTraversal0(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        // 如果步骤2中回溯上一层的右子节点非空的话(node != null)，则处理右子节点；如果右子节点为空，则继续向上回溯找右节点(跳过内层while循环，在步骤2处弹出栈顶节点，处理其右节点)
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                // 1、当前节点有左节点，按照前序中-左-右的顺序，需要先添加结果集(中)，然后入栈(左)
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }
            // 2、步骤1找左节点找到底层时，则回溯到上一层寻找右节点
            node = stack.pop();
            node = node.right;
        }
        return result;
    }
}
