package haiwaitu.t20211213;

import haiwaitu.ListNode;

import java.util.PriorityQueue;

/**
 * @Author huangjunqiao
 * @Date 2021/12/14 22:20
 * @Description 23. 合并K个升序链表
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        // 优先队列，时间：O(kNlogk)，空间：O(k)，N为最长链表长度
        int k = lists.length;
        ListNode dummy = new ListNode(0);
        ListNode merge = dummy;

        ListNode[] currIdxs = new ListNode[k];
        System.arraycopy(lists, 0, currIdxs, 0, k);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> currIdxs[a].val - currIdxs[b].val);
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                pq.offer(i);
            }
        }
        while (!pq.isEmpty()) {
            int min = pq.poll();
            merge.next = currIdxs[min];
            merge = merge.next;
            currIdxs[min] = currIdxs[min].next;

            if (currIdxs[min] != null) {
                pq.offer(min);
            }
        }
        return dummy.next;
    }

    public ListNode mergeKLists0(ListNode[] lists) {
        // 分治两两合并，时间：O(kNlogk)，空间：O(logk)
        return merge(lists, 0, lists.length - 1);
    }
    public ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start > end) {
            return null;
        }
        int mid = (start + end) >> 1;
        return mergeListNodes(merge(lists, start, mid), merge(lists, mid + 1, end));
    }
    public ListNode mergeListNodes(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if (l1 != null) {
            node.next = l1;
        } else if (l2 != null) {
            node.next = l2;
        }
        return dummy.next;
    }
}
