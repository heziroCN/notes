package haiwaitu.t20210821;

import java.util.PriorityQueue;

/**
 * @Author huangjunqiao
 * @Date 2021/08/22 11:32
 * @Description 1046. 最后一块石头的重量
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        // 最大堆，时间：O(NlogN)，空间：O(N)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            if (num1 > num2) {
                pq.offer(num1 - num2);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
