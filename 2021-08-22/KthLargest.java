package haiwaitu.t20210822;

import java.util.PriorityQueue;

/**
 * @Author huangjunqiao
 * @Date 2021/08/23 11:35
 * @Description 703. 数据流中的第 K 大元素
 */
public class KthLargest {
    // 类似题目：215. 数组中的第K个最大元素
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        // 最小堆，时间：初始化O(Nlogk)，插入O(logk)，空间：O(k)
        pq = new PriorityQueue<>((a, b) -> a - b);
        for (int num : nums) {
            pq.offer(num);
        }
        this.k = k;
    }

    public int add(int val) {
        pq.offer(val);
        while (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
