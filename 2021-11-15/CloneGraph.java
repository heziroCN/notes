package haiwaitu.t20211115;

import haiwaitu.Node;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/11/16 15:51
 * @Description 133. 克隆图
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {
        // BFS，时间：O(N)，空间：O(N)，用时：45min
        if (node == null) {
            return node;
        }
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        visited.put(node, new Node(node.val, new ArrayList<>()));
        while (!q.isEmpty()) {
            Node currNode = q.poll(), clone = visited.get(currNode);
            for (Node neighbor : currNode.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    q.offer(neighbor);
                }
                clone.neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }

    Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph0(Node node) {
        // DFS
        if (node == null) {
            return node;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;
    }
}
