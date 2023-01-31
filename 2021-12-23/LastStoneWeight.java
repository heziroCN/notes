package haiwaitu.t20211223;

import java.util.PriorityQueue;

/**
 * @Author huangjunqiao
 * @Date 2021/12/24 16:38
 * @Description 1046. 最后一块石头的重量
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        // 堆，时间：O(NlogN)，空间：O(N)，
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int max1 = pq.poll(), max2 = pq.poll();
            int newStone = max1 - max2;
            if (newStone != 0) {
                pq.offer(newStone);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
