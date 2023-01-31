package haiwaitu.t20220919;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2022/09/20 00:47
 * @Description 57. 插入区间
 */
public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 时间：O(n)，空间：O(n)
        List<int[]> list = new ArrayList<>();
        int left = newInterval[0], right = newInterval[1];
        boolean placed = false;
        for (int[] interval : intervals) {
            if (interval[1] < left) {
                list.add(interval);
            } else if (interval[0] > right) {
                if (!placed) {
                    list.add(new int[] {left, right});
                    placed = true;
                }
                list.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            list.add(new int[] {left, right});
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
