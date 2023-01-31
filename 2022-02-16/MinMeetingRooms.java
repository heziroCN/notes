package haiwaitu.t20220216;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author huangjunqiao
 * @Date 2022/02/17 16:05
 * @Description 253. 会议室 II
 */
public class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        // 时间：O(nlogn)，空间：O(n)
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        pq.offer(intervals[0][1]);
        for (int i = 1; i < n; i++) {
            if (pq.peek() <= intervals[i][0]) {
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }
        return pq.size();
    }

    public int minMeetingRooms0(int[][] intervals) {
        // 分别排序+双指针，时间：O(nlogn)，空间：O(n)
        int n = intervals.length;
        int[] starts = new int[n], ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int j = 0;
        int room = 0;
        for (int i = 0; i < n; i++) {
            if (starts[i] >= ends[j]) {
                j++;
            } else {
                room++;
            }
        }
        return room;
    }
}
