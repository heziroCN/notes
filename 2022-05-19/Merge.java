package haiwaitu.t20220519;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2022/05/19 18:07
 * @Description 56. 合并区间
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        // 时间：O(nlogn)，空间：O(logn)
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merges = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merges.size() == 0 || interval[0] > merges.get(merges.size() - 1)[1]) {
                merges.add(new int[] {interval[0], interval[1]});
            } else {
                merges.get(merges.size() - 1)[1] = Math.max(merges.get(merges.size() - 1)[1], interval[1]);
            }
        }
        return merges.toArray(new int[merges.size()][]);
    }
}
