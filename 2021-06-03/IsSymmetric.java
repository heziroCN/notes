package haiwaitu.t20210603;

import haiwaitu.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/06/04 14:29
 * @Description 101. 对称二叉树
 */
public class IsSymmetric {
    public boolean isSymmetric0(TreeNode root) {
        // 递归解法，时间每个节点遍历一次O(N)，空间为树高O(logN)
        return isSymmetricCore(root, root);
    }

    public boolean isSymmetricCore(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }
        return isSymmetricCore(node1.left, node2.right) &&
                isSymmetricCore(node1.right, node2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        // 迭代解法，时间O(N)，每个节点入队出队一次；空间O(N)，完美二叉树底层节点为N/2
        // 借助队列，开始将root入队两次，以后每次将镜像节点相邻入队；每次出队两个节点，两个节点不相等则返回false
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null || node1.val != node2.val) {
                // 发现不对称，可以马上返回结果了
                return false;
            }
            // 以镜像相邻的顺序入队
            queue.offer(node1.left);
            queue.offer(node2.right);

            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }
}
