package haiwaitu.t20220119;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2022/01/19 11:21
 * @Description 539. 最小时间差
 */
public class FindMinDifference {
    public int findMinDifference(List<String> timePoints) {
        // 时间：O(nlogn)，空间：O(logn)
        int n = timePoints.size();
        Collections.sort(timePoints);
        int res = 24 * 60;
        for (int i = 1; i < n; i++) {
            res = Math.min(res, getMinute(timePoints.get(i)) - getMinute(timePoints.get(i - 1)));
        }
        res = Math.min(res, 24 * 60 - getMinute(timePoints.get(n - 1)) + getMinute(timePoints.get(0)));
        return res;
    }
    public int getMinute(String t) {
        String[] arr = t.split(":");
        return Integer.valueOf(arr[0]) * 60 + Integer.valueOf(arr[1]);
    }
}
