package haiwaitu.t20210717;

import haiwaitu.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author huangjunqiao
 * @Date 2021/07/18 23:58
 * @Description 662. 二叉树最大宽度
 */
public class WidthOfBinaryTree {
     Map<Integer, Integer> left = new HashMap<>();
     int res = 0;
     public int widthOfBinaryTree(TreeNode root) {
         // DFS前序遍历，使用数组/HashMap记录每层的最左节点位置，递归过程不断更新最大宽度
         // 时间O(N)，空间O(N)
         dfs(root, 0, 0);
         return res;
     }
     public void dfs(TreeNode node, int depth, int pos) {
         if (node == null) {
             return;
         }
         // left.computeIfAbsent(depth, x-> pos);
         // res = Math.max(res, pos - left.get(depth) + 1);
         // 这样写耗时1ms，比使用computeIfAbsent的2ms快
         if (left.get(depth) == null) {
             left.put(depth, pos);
             res = Math.max(res, 1);
         } else {
             res = Math.max(res, pos - left.get(depth) + 1);
         }
         dfs(node.left, depth + 1, pos * 2);
         dfs(node.right, depth + 1, pos * 2 + 1);
     }

    public int widthOfBinaryTree0(TreeNode root) {
        // BFS解法，时间O(N)，空间O(N)
        if (root == null) {
            return 0;
        }
        Deque<AnnotatedNode> q = new LinkedList<>();
        q.offer(new AnnotatedNode(0, 0, root));
        // 根节点算第0层，每到新的一层currDepth+1
        int left = 0, currDepth = 0, ans = 0;
        while (!q.isEmpty()) {
            AnnotatedNode a = q.poll();
            if (a.node != null) {
                q.offer(new AnnotatedNode(a.depth + 1, a.pos * 2, a.node.left));
                q.offer(new AnnotatedNode(a.depth + 1, a.pos * 2 + 1, a.node.right));
                if (currDepth != a.depth) {
                    left = a.pos;
                    currDepth = a.depth;
                }
                ans = Math.max(ans, a.pos - left + 1);
            }
        }
        return ans;
    }

    class AnnotatedNode {
        int depth;
        int pos;
        TreeNode node;
        public AnnotatedNode(int depth, int pos, TreeNode node) {
            this.depth = depth;
            this.pos = pos;
            this.node = node;
        }
    }
}
