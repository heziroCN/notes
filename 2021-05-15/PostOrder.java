package haiwaitu.t20210515;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2021/05/16 22:51
 * @Description 590. N 叉树的后序遍历
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
}

public class PostOrder {
    public List<Integer> postorder(Node root) {
        // 递归解法
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, result);
        result.add(root.val);
        return result;
    }
    public void dfs(Node node, List<Integer> result) {
        if (node.children.isEmpty()) {
            return;
        }
        for (Node child : node.children) {
            dfs(child, result);
            result.add(child.val);
        }
    }

    public List<Integer> postorder0(Node root) {
        // 迭代解法
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            // 弹出栈尾部元素
            Node node = stack.pollLast();
            // 结果集先把父节点添加到栈顶部，后续遍历刚好就是要把父节点放在最后访问的，这里相当于反过来先把父节点添加到结果集的后面
            result.addFirst(node.val);
            for (Node child : node.children) {
                // 当前元素的子节点添加到栈尾部
                if (child != null) {
                    stack.add(child);
                }
            }
        }
        return result;
    }
}
