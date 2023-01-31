package haiwaitu.t20211223;

import java.util.PriorityQueue;

/**
 * @Author huangjunqiao
 * @Date 2021/12/24 16:38
 * @Description 1705. 吃苹果的最大数目
 */
public class EatenApples {
    public int eatenApples(int[] apples, int[] days) {
    // 堆，时间：O(Mlogn)，空间：O(n)，M为最后一个有苹果吃的日期
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a + days[a] - (b + days[b]));// 优先吃临近保质期的苹果
    int n = apples.length, today = 0;
    int res = 0;
    while (true) {
        if (today < n) {
            pq.offer(today);
        }
        while (!pq.isEmpty() && (apples[pq.peek()] == 0 || pq.peek() + days[pq.peek()] <= today)) {
            pq.poll();// 移除已经吃完或者过期的苹果
        }
        if (!pq.isEmpty()) {
            apples[pq.peek()]--;
            res++;
        }
        if (today >= n && pq.isEmpty()) {
            return res;
        }
        today++;
    }
    // return res;
}
}
