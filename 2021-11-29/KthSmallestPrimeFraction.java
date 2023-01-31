package haiwaitu.t20211129;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author huangjunqiao
 * @Date 2021/11/30 01:56
 * @Description 786. 第 K 个最小的素数分数
 */
public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // 暴力解法，时间：O(N^2(logN))，空间：O(N^2)
        int len = arr.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                list.add(new int[]{arr[i], arr[j]});
            }
        }
        Collections.sort(list, (x, y) -> x[0] * y[1] - x[1] * y[0]);
        return list.get(k - 1);
    }

    public int[] kthSmallestPrimeFraction0(int[] arr, int k) {
        // 堆排序，时间：O(klogN)，空间：O(N)
        // 将以arr[j]为分母的分数视作一个列表，则所有分数由N个有序列表组成。参考合并k个有序数组。
        int len = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x , y) -> arr[x[0]] * arr[y[1]] - arr[x[1]] * arr[y[0]]);
        for (int j = 1; j < len; j++) {
            pq.offer(new int[]{0, j});
        }
        for (int i = 1; i < k; i++) {
            int[] cur = pq.poll();
            if (cur[0] + 1 < cur[1]) {
                pq.offer(new int[]{cur[0] + 1, cur[1]});
            }
        }
        return new int[] {arr[pq.peek()[0]], arr[pq.peek()[1]]};
    }
}
