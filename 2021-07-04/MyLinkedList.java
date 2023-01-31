package haiwaitu.t20210704;

import haiwaitu.ListNode;

/**
 * @Author huangjunqiao
 * @Date 2021/07/05 11:08
 * @Description 707. 设计链表
 */
public class MyLinkedList {
     // 单链表解法，空间复杂度均为O(1)，get时间O(N)；addAtHead时间O(1)；
     // addAtTail、addAtIndex时间O(N)；deleteAtIndex时间O(N)
//     int size;
//     ListNode head;
//     public MyLinkedList() {
//         head = new ListNode(0);
//         size = 0;
//     }
//
//     public int get(int index) {
//         if (index < 0 || index >= size) {
//             return -1;
//         }
//         ListNode node = head;
//         for (int i = 0; i < 1 + index; ++i) {
//             node = node.next;
//         }
//         return node.val;
//     }
//
//     public void addAtHead(int val) {
//         addAtIndex(0, val);
//     }
//
//     public void addAtTail(int val) {
//         addAtIndex(size, val);
//     }
//
//     public void addAtIndex(int index, int val) {
//         if (index > size) {
//             return;
//         }
//         if (index < 0) {
//             index = 0;
//         }
//         // 找到待插入的前一个节点，在其next位置插入
//         ListNode node = head;
//         for (int i = 0; i < index; ++i) {
//             node = node.next;
//         }
//         ListNode newNode = new ListNode(val);
//         newNode.next = node.next;
//         node.next = newNode;
//         size++;
//     }
//
//     public void deleteAtIndex(int index) {
//         if (index < 0 || index >= size) {
//             return;
//         }
//         // 找到待删的前一个节点，删除其next
//         ListNode node = head;
//         for (int i = 0; i < index; ++i) {
//             node = node.next;
//         }
//         node.next = node.next.next;
//         size--;
//     }


    // ---------双向链表-----------
    // 时空复杂度分析同单链表，区别是addAtTail、deleteAtIndex时间从O(N)优化到O(1)
    int size;
    ListNode head;
    ListNode tail;
    public MyLinkedList() {
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode node = head;
        if (index * 2 < size - 1) {
            // 如果位置在前半部分，从头开始查找
            for (int i = 0; i < 1 + index; ++i) {
                node = node.next;
            }
        } else {
            node = tail;
            // 如果位置在后半部分，从尾开始查找
            for (int i = 0; i < size - index; ++i) {
                node = node.prev;
            }
        }
        return node.val;
    }

    public void addAtHead(int val) {
        ListNode succ = head.next;
        ListNode newNode = new ListNode(val);
        head.next = newNode;
        newNode.next = succ;

        succ.prev = newNode;
        newNode.prev = head;
        size++;
    }

    public void addAtTail(int val) {
        // 插入操作指针修改顺序，1、设置插入节点next；2、设置指向插入节点的prev；3、设置指向插入节点的next；4、设置插入节点的prev；
        ListNode pred = tail.prev;
        ListNode newNode = new ListNode(val);
        pred.next = newNode;
        newNode.next = tail;

        tail.prev = newNode;
        newNode.prev = pred;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode newNode = new ListNode(val);
        ListNode pred, succ;
        if (index * 2 < size) {
            pred = head;
            // 如果位置在前半部分，从头开始查找
            for (int i = 0; i < index; ++i) {
                pred = pred.next;
            }
            succ = pred.next;
        } else {
            succ = tail;
            // 如果位置在后半部分，从尾开始查找
            for (int i = 0; i < size - index; ++i) {
                succ = succ.prev;
            }
            pred = succ.prev;
        }
        pred.next = newNode;
        newNode.next = succ;
        succ.prev = newNode;
        newNode.prev = pred;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode pred, succ;
        if (index * 2 < size - 1) {
            // 如果位置在前半部分，从头开始查找
            pred = head;
            for (int i = 0; i < index; ++i) {
                pred = pred.next;
            }
            succ = pred.next.next;
        } else {
            // 如果位置在后半部分，从尾开始查找
            succ = tail;
            for (int i = 0; i < size - index - 1; ++i) {
                succ = succ.prev;
            }
            pred = succ.prev.prev;
        }
        pred.next = succ;
        succ.prev = pred;
        size--;
    }

}
