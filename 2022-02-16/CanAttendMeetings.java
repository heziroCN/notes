package haiwaitu.t20220216;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2022/02/17 16:04
 * @Description 252. 会议室
 */
public class CanAttendMeetings {
    public boolean canAttendMeetings(int[][] intervals) {
        // 时间：O(n+sort(n))，空间：O(sort(n))
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
