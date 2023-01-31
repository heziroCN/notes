package haiwaitu.t20210606;

import haiwaitu.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/06/07 17:05
 * @Description 100. 相同的树
 */
public class IsSameTree {
     public boolean isSameTree0(TreeNode p, TreeNode q) {
         // DFS解法，时间O(min(M,N))，M为p的节点数，N为q的节点数。空间O(min(M,N))
         if (p == null && q == null) {
             return true;
         }
         if (p == null || q == null || p.val != q.val) {
             return false;
         }
         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
     }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // BFS解法，时间O(min(M,N))，M为p的节点数，N为q的节点数。空间O(min(M,N))
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        Deque<TreeNode> q1 = new LinkedList<>();
        Deque<TreeNode> q2 = new LinkedList<>();
        q1.offer(p);
        q2.offer(q);
        while (!q1.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if (node1.val != node2.val) {
                return false;
            }
            if (node1.left == null && node2.left == null) {
                // 两边均为空，无需入队，继续遍历
            } else if (node1.left == null || node2.left == null) {
                // 其中一个为空，结构不一致，返回false
                return false;
            } else {
                // 两边都不为空，入队后继续遍历
                q1.offer(node1.left);
                q2.offer(node2.left);
            }
            if (node1.right == null && node2.right == null) {
            } else if (node1.right == null || node2.right == null) {
                return false;
            } else {
                q1.offer(node1.right);
                q2.offer(node2.right);
            }
        }
        return true;
    }

}
