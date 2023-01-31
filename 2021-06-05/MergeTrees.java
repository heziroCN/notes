package haiwaitu.t20210605;

import haiwaitu.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/06/06 16:54
 * @Description 617. 合并二叉树
 */
public class MergeTrees {
     public TreeNode mergeTrees0(TreeNode t1, TreeNode t2) {
         // DFS解法，时间复杂度O(min(N1,N2))，空间复杂度O(min(N1,N2))
         if (t1 == null)
             return t2;
         if (t2 == null)
             return t1;
         t1.val += t2.val;
         t1.left = mergeTrees(t1.left, t2.left);
         t1.right = mergeTrees(t1.right, t2.right);
         return t1;
     }

     public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
         // DFS，栈模拟递归解法，时间O(N)，空间O(N)
         if (t1 == null) {
             return t2;
         }
         // 数组[m,n]m存放t1节点，n存放t2节点
         LinkedList<TreeNode[]> stack = new LinkedList<>();
         stack.push(new TreeNode[] {t1, t2});
         while (!stack.isEmpty()) {
             TreeNode[] t = stack.pop();
             // 如果t1和t2节点都为空，或者t2为空，继续遍历其他节点
             if (t[0] == null || t[1] == null) {
                 continue;
             }
             t[0].val += t[1].val;
             if (t[0].left == null) {
                 t[0].left = t[1].left;
             } else {
                 stack.push(new TreeNode[] {t[0].left, t[1].left});
             }
             if (t[0].right == null) {
                 t[0].right = t[1].right;
             } else {
                 stack.push(new TreeNode[] {t[0].right, t[1].right});
             }
         }
         return t1;
     }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // BFS解法,每个节点至多出入队列一次，时间O(min(N1,N2))，空间O(min(N1,N2))
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        Deque<TreeNode> q1 = new LinkedList<>();
        Deque<TreeNode> q2 = new LinkedList<>();
        q1.offer(t1);
        q2.offer(t2);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode child1 = q1.poll();
            TreeNode child2 = q2.poll();
            child1.val += child2.val;
            if (child1.left != null && child2.left != null) {
                q1.offer(child1.left);
                q2.offer(child2.left);
            } else if (child1.left == null) {
                child1.left = child2.left;
            }
            if (child1.right != null && child2.right != null) {
                q1.offer(child1.right);
                q2.offer(child2.right);
            } else if (child1.right == null) {
                child1.right = child2.right;
            }
        }
        return t1;
    }
}
