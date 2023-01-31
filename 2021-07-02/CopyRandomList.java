package haiwaitu.t20210702;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangjunqiao
 * @Date 2021/07/03 13:15
 * @Description 138. 复制带随机指针的链表
 */
public class CopyRandomList {
    Map<Node, Node> visited = new HashMap<>();
    // public Node copyRandomList(Node head) {
    //     // 回溯，将链表看做图，用HashMap记录访问过的节点。时间O(N)，空间O(N)
    //     if (head == null) {
    //         return null;
    //     }
    //     // 访问过可以直接返回
    //     if (visited.containsKey(head)) {
    //         return visited.get(head);
    //     }
    //     // 没访问过，则是新节点，需要创建并递归构建其next和random链
    //     Node node = new Node(head.val);
    //     visited.put(head, node);
    //     node.next = copyRandomList(head.next);
    //     node.random = copyRandomList(head.random);
    //     return node;
    // }

    // public Node copyRandomList(Node head) {
    //     // 迭代解法，同样适用HashMap记录访问过的节点，时间O(N)，空间O(N)
    //     if (head == null) {
    //         return null;
    //     }
    //     Node oldNode = head;
    //     Node newNode = new Node(oldNode.val);
    //     visited.put(oldNode, newNode);
    //     while (oldNode != null) {
    //         newNode.next = getClonedNode(oldNode.next);
    //         newNode.random = getClonedNode(oldNode.random);

    //         oldNode = oldNode.next;
    //         newNode = newNode.next;
    //     }
    //     return visited.get(head);
    // }

    // public Node getClonedNode(Node node) {
    //     if (node == null) {
    //         return null;
    //     }
    //     if (visited.containsKey(node)) {
    //         return visited.get(node);
    //     } else {
    //         Node newNode = new Node(node.val);
    //         visited.put(node, newNode);
    //         return newNode;
    //     }
    // }

    public Node copyRandomList(Node head) {
        // 交错编织新旧链表，A->B->C编织后：A->A'->B->B'->C->C'，时间O(N)，空间O(1)
        if (head == null) {
            return null;
        }
        // 1、交错插入新节点（处理next指针）
        Node ptr = head;
        while (ptr != null) {
            Node node = new Node(ptr.val);
            node.next = ptr.next;
            ptr.next = node;
            ptr = ptr.next.next;
        }
        // 2、处理random指针
        ptr = head;
        while (ptr != null) {
            ptr.next.random = (ptr.random == null) ? null : ptr.random.next;
            ptr = ptr.next.next;
        }
        // 3、拆分新旧链表
        Node oldNode = head, newNode = head.next;
        Node newHead = head.next;
        while (oldNode != null) {
            // 到链表末尾，new指针需要注意NPE问题
            oldNode.next = oldNode.next.next;
            newNode.next = (newNode.next == null) ? null : newNode.next.next;

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return newHead;
    }

}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
