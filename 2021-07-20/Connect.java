package haiwaitu.t20210721;

import haiwaitu.Node;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/07/20 22:55
 * @Description 116. 填充每个节点的下一个右侧节点指针
 */
public class Connect {
    public Node connect(Node root) {
        // BFS层序遍历，时间O(N)，空间O(N)
        if (root == null) {
            return root;
        }
        Deque<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                // 每层最后一个节点next不需要设置
                if (i < size - 1) {
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

    public Node connect0(Node root) {
        // DFS迭代，利用next指针节省空间，时间O(N)，空间O(1)
        if (root == null) {
            return root;
        }
        Node leftmost = root;
        // 由于是完美二叉树，当一层的最左节点不存在时，说明这一层没节点了
        while (leftmost.left != null) {
            Node node = leftmost;
            while (node != null) {
                // 设置左子节点的next
                node.left.next = node.right;
                if (node.next != null) {
                    // 设置右子节点的next
                    node.right.next = node.next.left;
                }
                node = node.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}
