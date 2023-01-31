package haiwaitu.t20210528;

import haiwaitu.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author huangjunqiao
 * @Date 2021/05/28 17:40
 * @Description 107. 二叉树的层序遍历 II
 */
public class LevelOrderButtom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 层序遍历，可以通过队列进行BFS；
        // 结果要求自底向上，可以将BFS的结果列表反转，或者从双端链表头部添加元素
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            int currNum = queue.size();
            for (int i = 0; i < currNum; i++) {
                node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                subList.add(node.val);
            }
            result.add(0, subList);
        }
        return result;
    }
}
