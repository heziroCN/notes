package haiwaitu.t20210426;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author huangjunqiao
 * @Date 2021/04/26 15:29
 * @Description 102. 二叉树的层序遍历
 */
public class LevelOrder {

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

    /**
     * 树的层序遍历属于BFS，借助队列完成，由于
     * 结果集要求存储每一层作为一个列表，所以在遍历
     * 的过程需要记录每层有几个节点，并分开存储
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // 添加头节点初始化队列
        queue.offer(root);
        while (!queue.isEmpty()) {
            int currLevelSize = queue.size();
            TreeNode currNode;
            List<Integer> subResult = new ArrayList<>();
            for (int i = 0; i < currLevelSize; i++) {
                // 弹出后按遍历方向（左-右）入队
                currNode = queue.poll();
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
                subResult.add(currNode.val);
            }
            result.add(subResult);
        }
        return result;
    }
}
