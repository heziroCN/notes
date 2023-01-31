package haiwaitu.t20211217;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author huangjunqiao
 * @Date 2021/12/18 23:30
 * @Description 373. 查找和最小的K对数字
 */
public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 优先队列+剪枝（数组有序，当堆的size达到k，且当前数字比堆里最大数更大时可以break）时间：O(MNlogk+klogk)，空间：O(k)。M、N为两数组长度
        int len1 = nums1.length, len2 = nums2.length;
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> b.get(0) + b.get(1) - (a.get(0) + a.get(1)));
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                List<Integer> currMin = pq.peek();
                if (pq.size() == k && nums1[i] + nums2[j] >= currMin.get(0) + currMin.get(1)) {
                    break;
                }
                pq.offer(buildList(i, j, nums1, nums2));
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        return res;
    }
    public List<Integer> buildList(int i, int j, int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        list.add(nums1[i]);
        list.add(nums2[j]);
        return list;
    }
}
