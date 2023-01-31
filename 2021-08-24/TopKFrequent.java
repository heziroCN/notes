package haiwaitu.t20210824;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/08/28 02:53
 * @Description 347. 前 K 个高频元素
 */
public class TopKFrequent {
    // 类似题目：692. 前K个高频单词
    public int[] topKFrequent(int[] nums, int k) {
        // 堆，时间：O(Nlogk)，空间：O(N)
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                new Comparator<Map.Entry<Integer, Integer>>() {
                    public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                        return e1.getValue() - e2.getValue();
                    }
                });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        int idx = 0;
        while (!pq.isEmpty()) {
            res[idx++] = pq.poll().getKey();
        }
        return res;
    }

    // public static void quickSort(int start, int end, List<int[]> list, int[] result, int resultIndex, int k) {
    //     int picket = (int) (Math.random() * (end - start + 1)) + start;
    //     int pivot = list.get(picket)[1];
    //     swap(list, picket, end);
    //     int index = start;
    //     for (int i = start; i < end; i++) {
    //         if (list.get(i)[1] >= pivot) {
    //             swap(list, index, i);
    //             index++;
    //         }
    //     }
    //    swap(list, index, end);

    //     if (k < index - start + 1) {
    //         quickSort(start, index - 1, list, result, resultIndex, k);
    //     } else {
    //         for (int i = start; i <= index; i++) {
    //             result[resultIndex++] = list.get(i)[0];
    //         }
    //         if (k == index - start + 1) {
    //             // find top k, over
    //             return;
    //         }
    //         quickSort(index + 1, end, list, result, resultIndex,k - (index - start + 1));
    //     }
    // }
    // public static void swap(List<int[]> list, int l, int r) {
    //     int[] temp = list.get(l);
    //     list.set(l, list.get(r));
    //     list.set(r, temp);
    // }
}
