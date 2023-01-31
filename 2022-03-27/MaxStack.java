package haiwaitu.t20220327;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @Author huangjunqiao
 * @Date 2022/03/27 17:51
 * @Description 716. 最大栈
 */
public class MaxStack {
    // 双栈
    // Deque<Integer> stk = new LinkedList<>(), maxStk = new LinkedList<>();
    // public MaxStack() {
    // }

    // public void push(int x) {
    //     stk.push(x);
    //     int max = maxStk.isEmpty() ? x : maxStk.peek();
    //     maxStk.push(x > max ? x : max);
    // }

    // public int pop() {
    //     maxStk.pop();
    //     return stk.pop();
    // }

    // public int top() {
    //     return stk.peek();
    // }

    // public int peekMax() {
    //     return maxStk.peek();
    // }

    // public int popMax() {
    //     int max = maxStk.peek();
    //     Deque<Integer> buff = new LinkedList<>();
    //     while (top() != max) {
    //         buff.push(pop());
    //     }
    //     pop();
    //     while (!buff.isEmpty()) {
    //         push(buff.pop());
    //     }
    //     return max;
    // }

    // 链表+平衡树
    TreeMap<Integer, List<Node>> map = new TreeMap<>();
    DLinkedList dll = new DLinkedList();
    public MaxStack() {}
    public void push(int x) {
        Node node = dll.push(x);
        if (!map.containsKey(x)) {
            List<Node> list = new ArrayList<>();
            map.put(x, list);
        }
        map.get(x).add(node);
    }
    public int pop() {
        Node node = dll.pop();
        List<Node> list = map.get(node.val);
        list.remove(list.size() - 1);
        if (list.isEmpty()) {
            map.remove(node.val);
        }
        return node.val;
    }
    public int top() {
        return dll.peek().val;
    }
    public int peekMax() {
        return map.lastKey();
    }
    public int popMax() {
        int max = map.lastKey();
        List<Node> maxList = map.get(max);
        Node node = maxList.remove(maxList.size() - 1);
        dll.remove(node);
        if (maxList.isEmpty()) {
            map.remove(max);
        }
        return max;
    }

    class DLinkedList {
        Node head, tail;
        public DLinkedList() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }
        public Node push(int x) {
            Node node = new Node(x);
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            return node;
        }
        public Node pop() {
            Node node = tail.prev;
            tail.prev = node.prev;
            node.prev.next = tail;
            return node;
        }
        public Node peek() {
            return tail.prev;
        }
        public Node remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }
    }
    class Node {
        Node next;
        Node prev;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }
}
