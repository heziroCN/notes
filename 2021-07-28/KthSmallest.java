package haiwaitu.t20210728;

import haiwaitu.TreeNode;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/07/29 03:52
 * @Description 230. 二叉搜索树中第K小的元素
 */
public class KthSmallest {
    public int kthSmallest0(TreeNode root, int k) {
        // DFS迭代，平均时间复杂度O(H+k)，H为树高，最坏情况下退化成链表，时间O(N+k)，即O(N)，同理空间复杂度O(N)
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (--k == 0) {
                return node.val;
            }
            node = node.right;
        }
        return 0;
    }

    public int kthSmallest(TreeNode root, int k) {
        // DFS递归，时间复杂度O(N)，空间复杂度O(N)
        List<Integer> list = dfs(root, new ArrayList<>());
        return list.get(k - 1);
    }
    public List<Integer> dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return list;
        }
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
        return list;
    }
}
