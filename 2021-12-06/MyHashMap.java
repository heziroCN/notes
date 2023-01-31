package haiwaitu.t20211206;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2021/12/07 23:49
 * @Description 706. 设计哈希映射
 */
public class MyHashMap {
    // 时间：查找、添加和删除都是平均O(1)，最坏情况下O(N)
    final int MAX_CAP = 10000;
    Node[] data = new Node[MAX_CAP];
    public MyHashMap() {
        Arrays.fill(data, new Node(-1, -1));//dummy
    }

    public void put(int key, int value) {
        Node node = data[key % MAX_CAP];
        while (node.next != null) {
            if (node.next.key == key) {
                node.next.val = value;
                return;
            }
            node = node.next;
        }
        node.next = new Node(key, value);
    }

    public int get(int key) {
        Node node = data[key % MAX_CAP];
        while (node.next != null) {
            if (node.next.key == key) {
                return node.next.val;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        Node node = data[key % MAX_CAP];
        while (node.next != null) {
            if (node.next.key == key) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }
}
class Node {
    Node next;
    int key;
    int val;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}