package haiwaitu.t20210508;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/05/08 15:23
 * @Description 103. 二叉树的锯齿形层序遍历
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        TreeNode node = root;
        q.offer(node);

        int levelSize = 0;
        // 遍历方向标志，当前是否应该从右向左遍历
        boolean right2Left = false;
        while (!q.isEmpty()) {
            Deque<Integer> valDeque = new LinkedList<>();
            levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                node = q.poll();
                // 双端队列根据right2Left标志位决定入队方向，从而改变遍历方向
                if (right2Left) {
                    valDeque.offerFirst(node.val);
                } else {
                    valDeque.offerLast(node.val);
                }
                // 下一层节点入队
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            // 更改遍历方向标志，收集结果
            right2Left = !right2Left;
            result.add(new ArrayList<>(valDeque));
        }
        return result;
    }

    class TreeNode {
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
}
