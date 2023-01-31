package haiwaitu.t20210902;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author huangjunqiao
 * @Date 2021/09/02 22:43
 * @Description 239. 滑动窗口最大值
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 堆，由于延后删除，堆大小能达到N，时间：O(NlogN)，空间：O(N)
        PriorityQueue<int[]> pq = new PriorityQueue<>(// 存储元素和下标
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] pair1, int[] pair2) {
                        return pair1[0] == pair2[0] ? pair1[1] - pair2[1] : pair2[0] - pair1[0];
                    }
                }
        );
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        int len = nums.length;
        int[] res = new int[len - k + 1];
        res[0] = pq.peek()[0];
        for (int i = k; i < len; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                // 如果堆顶的最大元素在窗口外左边，才需要立即删除。窗口外的元素，如果不是堆里最大，不会对结果造成影响，可以延后删除。
                pq.poll();
            }
            res[i - k + 1] = pq.peek()[0];
        }
        return res;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        // 单调的双端队列，队列单调递减保证了队头元素窗口内最大，时间：O(N)，空间：O(k)
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            // 维持队列单调递减
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int len = nums.length;
        int[] res = new int[len - k + 1];
        res[0] = nums[deque.peekFirst()];
        for (int i = k; i < len; i++) {
            // 维持队列单调递减
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // 维持窗口大小
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }

    public int[] maxSlidingWindow0(int[] nums, int k) {
        // 分块+预处理(稀疏表)，时间：O(N)，空间：O(N)
        // 将所有整数k个一组分组，记录每组的最大值，对于任意滑动窗口[i,i+k-1]内，有两种情况，
        // 1、i是k的倍数，则[i,i+k-1]的最大值直接从预处理的数组里取即可。
        // 2、i不是k的倍数，则区间最大值为[i,mk-1]和[mk,i+k-1]两个区间最大值较大的那个
        int len = nums.length;
        int[] prefixMax = new int[len];
        int[] suffixMax = new int[len];
        for (int i = 0; i < len; i++) {
            if (i % k == 0) {
                prefixMax[i] = nums[i];
            } else {
                prefixMax[i] = Math.max(nums[i], prefixMax[i - 1]);
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1 || (i + 1) % k == 0) {// 如果写i%k==0的话，0和1，2会分到不同的两组去
                suffixMax[i] = nums[i];
            } else {
                suffixMax[i] = Math.max(nums[i], suffixMax[i + 1]);
            }
        }
        int[] res = new int[len - k + 1];
        for (int i = 0; i <= len - k; i++) {
            res[i] = Math.max(prefixMax[i + k - 1], suffixMax[i]);
        }
        return res;
    }
}
