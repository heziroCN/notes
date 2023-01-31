package haiwaitu.t20220122;

import haiwaitu.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author huangjunqiao
 * @Date 2022/01/22 12:04
 * @Description 117. 填充每个节点的下一个右侧节点指针 II
 */
public class Connect {
    public Node connect(Node root) {
        // 基于队列的BFS，时间：O(n)，空间：O(n)
        if (root == null) {
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Node node = q.poll();
                if (i != sz - 1) {
                    node.next = q.peek();
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return root;
    }

    Node last, nextStart;
    public Node connect0(Node root) {
        // 基于next指针的BFS，时间：O(n)，空间：O(1)
        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node node = start; node != null; node = node.next) {
                if (node.left != null) {
                    handle(node.left);
                }
                if (node.right != null) {
                    handle(node.right);
                }
            }
            start = nextStart;
        }
        return root;
    }
    public void handle(Node node) {
        if (nextStart == null) {
            nextStart = node;
        }
        if (last != null) {
            last.next = node;
        }
        last = node;
    }
}
