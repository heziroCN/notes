package haiwaitu.t20210512;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2021/05/13 09:20
 * @Description 589. N 叉树的前序遍历
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

public class PreOrder {
    public List<Integer> preorder(Node root) {
        // 递归解法
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    public void preOrder(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        for (Node child : node.children) {
            preOrder(child, result);
        }
    }

    public List<Integer> preorder0(Node root) {
        // 迭代解法
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            result.add(node.val);
            Collections.reverse(node.children);
            for (Node child : node.children) {
                stack.add(child);
            }
        }
        return result;
    }

}
