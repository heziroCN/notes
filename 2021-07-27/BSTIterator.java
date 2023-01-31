package haiwaitu.t20210727;

import haiwaitu.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2021/07/28 03:51
 * @Description 173. 二叉搜索树迭代器
 */
public class BSTIterator {
    // TreeNode curr;
    // Deque<TreeNode> stack;
    // public BSTIterator(TreeNode root) {
    //     curr = root;
    //     stack = new LinkedList<>();
    // }
    // public int next() {
    //     // 迭代，平均时间复杂度O(1)，最坏O(N)，空间O(N)
    //     while (curr != null) {
    //         stack.push(curr);
    //         curr = curr.left;
    //     }
    //     curr = stack.pop();
    //     int val = curr.val;
    //     curr = curr.right;
    //     return val;
    // }
    // public boolean hasNext() {
    //     return !stack.isEmpty() || curr != null;
    // }
    int idx = 0;
    List<Integer> list = new ArrayList<>();
    public BSTIterator(TreeNode root) {
        dfs(root);
    }
    public int next() {
        // 递归解法，先把所有节点添加到list里，时间O(N)，空间O(N)
        return list.get(idx++);
    }
    public boolean hasNext() {
        return idx < list.size();
    }
    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }
}
