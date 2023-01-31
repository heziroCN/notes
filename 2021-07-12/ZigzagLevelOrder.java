package haiwaitu.t20210712;

import haiwaitu.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2021/07/13 16:52
 * @Description 103. 二叉树的锯齿形层序遍历
 */
public class ZigzagLevelOrder {
     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         // BFS迭代解法，使用一个单向队列实现层序遍历，用双向队列和一个方向标志，从单向队列取出节点，交替从双向队列的队头和队尾入队，实现两个方向的遍历，时间O(N)，空间O(N)
         List<List<Integer>> result = new ArrayList<>();
         if (root == null) {
             return result;
         }
         Deque<TreeNode> q = new LinkedList<>();
         q.offer(root);
         // 当前层节点的遍历方向，第一层从左向右
         boolean left2Right = true;
         TreeNode node = root;
         while (!q.isEmpty()) {
             int levelSize = q.size();
             Deque<Integer> deque = new LinkedList<>();
             for (int i = 0; i < levelSize; i++) {
                 node = q.poll();
                 // 构建单向队列（下一层节点）
                 if (node.left != null) {
                     q.offer(node.left);
                 }
                 if (node.right != null) {
                     q.offer(node.right);
                 }
                 // 构建双向队列（当前层结果集）
                 if (left2Right) {
                     deque.offerLast(node.val);
                 } else {
                     deque.offerFirst(node.val);
                 }
             }
             result.add(new ArrayList<>(deque));
             left2Right = !left2Right;
         }
         return result;
     }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder0(TreeNode root) {
        // DFS递归解法（前序遍历更方便，虽然对于兄弟节点来说，三种DFS都是先访问左节点然后右节点，但是中序和后序遍历，都是从下往上遍历，会导致result也要使用链表，从后往前添加subList。并且根据level取subList的逻辑也要改为 maxLevel-level ）,时间O(N)，空间O(N)
        dfs(root, 1);
        return result;
    }
    public void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        List<Integer> subList;
        // 设根节点为第1层，若result的size小于当前level，则当前层的链表还没创建
        if (result.size() < level) {
            subList = new LinkedList<>();
            result.add(subList);
        } else {
            subList = result.get(level - 1);
        }
        if (level % 2 == 0) {
            subList.add(0, node.val);
        } else {
            subList.add(node.val);
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
