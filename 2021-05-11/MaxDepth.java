package haiwaitu.t20210511;

import javafx.util.Pair;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/05/11 14:45
 * @Description 559. N 叉树的最大深度
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class MaxDepth {
    static int max = 0;
    public static int maxDepth(Node root) {
        dfs(root, 1);
        return max;
    }
    public static void dfs(Node node, int currDepth) {
        if (node.children == null) {
            // 到叶子节点了，更新深度最大值
            max = currDepth > max ? currDepth : max;
        } else {
            for (Node childNode : node.children) {
                dfs(childNode, currDepth + 1);
            }
        }
    }

    public int maxDepth0(Node root) {
        // 迭代解法(BFS，借助队列实现) 也可以把队列换成栈实现DFS的迭代
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        if (root != null) {
            queue.add(new Pair(root, 1));
        }
        Node node = null;
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            Pair<Node, Integer> p = queue.poll();
            root = p.getKey();
            if (root == null) {
                continue;
            } else {
                int currDepth = p.getValue();
                maxDepth = Math.max(maxDepth, currDepth);
                for (Node child : root.children) {
                    queue.add(new Pair(child, currDepth + 1));
                }
            }
        }
        return maxDepth;
    }
}
