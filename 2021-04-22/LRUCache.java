package haiwaitu.t20210422;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangjunqiao
 * @Date 2021/04/22 16:00
 * @Description 146. LRU 缓存机制
 * 做的过程出现了忘记更新hashMap元素，和淘汰的时候remove错元素 两个错误
 */
public class LRUCache {
    /**
     * 双向链表把最近被使用的元素放在头部，
     * 容量到达上限时删除尾部元素
     */
    class DLinkedNode {
        private DLinkedNode prev;
        private DLinkedNode next;
        private int key;
        private int value;

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public DLinkedNode() {}
    }

    /**
     * map提供O（1）的定位元素能力
     */
    private Map<Integer, DLinkedNode> map = new HashMap<>();

    private DLinkedNode head;
    private DLinkedNode tail;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node;
        if ((node = map.get(key)) == null) {
            return -1;
        }
        // 将被访问移动到链表头部
        move2Head(node);
        return node.value;
    }
    public void put(int key, int value) {
        DLinkedNode node;
        if ((node = map.get(key)) != null) {
            // 存在则更新
            node.value = value;
            // 将被访问移动到链表头部
            move2Head(node);
            return;
        }
        // 不存在则新建一个节点
        node = new DLinkedNode(key, value);
        map.put(key, node);
        // 更新head相关指针
        DLinkedNode ori1stNode = head.next;
        head.next = node;
        ori1stNode.prev = node;
        // 更新node相关指针
        node.prev = head;
        node.next = ori1stNode;
        size++;
        // 达到容量上限，淘汰链表末尾的元素
        if (size > capacity) {
            map.remove(tail.prev.key);
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
            size--;
        }
    }

    /**
     * 被访问的元素移动到链表头部，避免被淘汰
     * @param node
     */
    public void move2Head(DLinkedNode node) {
        if (node == null || node == head.next) {
            return;
        }

        // 更新node原来的指针
        DLinkedNode oriPrev = node.prev;
        DLinkedNode oriNext = node.next;
        oriNext.prev = oriPrev;
        oriPrev.next = oriNext;
        // 更新head相关指针
        DLinkedNode ori1stNode = head.next;
        ori1stNode.prev = node;
        head.next = node;
        // 更新node相关指针
        node.next = ori1stNode;
        node.prev = head;
    }

}
