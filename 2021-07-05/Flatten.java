package haiwaitu.t20210705;

import haiwaitu.Node;

import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/07/06 19:21
 * @Description 430. 扁平化多级双向链表
 */
public class Flatten {public Node flatten(Node head) {
    // 递归解法，时间：每个节点遍历一次，O(N)，空间：每个节点都产生递归一次，O(N)
    if (head == null) {
        return head;
    }
    Node dummy = new Node(0, null, head, null);
    dfs(dummy, head);
    // 递归会把head的prev指向dummy节点，需要重置为null
    head.prev = null;
    return head;
}

    // 仅分析dfs(curr, curr.child)的情况，dfs(tail, tempNext)较简单，分析省略。
    public Node dfs(Node prev, Node curr) {
        // 1.1、如果child不为null，则返回prev在2、处继续向后遍历
        if (curr == null) {
            return prev;
        }
        // 1.2、如果child不为null，把child(curr)接到prev的后面，并缓存原来的next节点
        prev.next = curr;
        curr.prev = prev;
        Node tempNext = curr.next;
        // 2、如果child为null，会在下次递归的1、处返回当前curr，方便在3、处继续向后遍历；如果不为null，则继续递归处理，并返回子链表(递归到底层)的尾节点。
        Node tail = dfs(curr, curr.child);
        curr.child = null;
        // 3、tail为当前节点，tempNext为下一个节点(无child)，或者子链表(如有)递归到底层的尾节点。
        return dfs(tail, tempNext);
    }

    public Node flatten0(Node head) {
        // 迭代解法，缓存prev节点，遇到子节点则先把next入栈，然后入栈子节点。每次迭代连接prev和栈顶节点。时间：每个节点入栈出栈一次，O(N)，空间：栈空间为子链表数目，最坏情况下所有节点都有子链表，O(N)
        if (head == null) {
            return head;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(head);
        Node dummy = new Node(0, null, head, null);
        Node prev = dummy, curr;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            // 连接缓存的prev和当前节点
            curr.prev = prev;
            prev.next = curr;
            if (curr.next != null) {
                stack.push(curr.next);
            }
            // 遇到chlid，入栈
            if (curr.child != null) {
                stack.push(curr.child);
                curr.child = null;
            }
            // prev向后移动一个位置
            prev = curr;
        }
        head.prev = null;
        return head;
    }
}
