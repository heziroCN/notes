package haiwaitu.t20220424;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2022/04/24 22:59
 * @Description 6043. 统计包含每个点的矩形数目
 */
public class CountRectangles {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        // 时间：O(H*sort(m) + H*n)，空间：O(H + sort(m))，m为矩形数量，n为点points的数量，H为高度范围
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] rec : rectangles) {
            if (!map.containsKey(rec[1])) {
                map.put(rec[1], new ArrayList<>());
            }
            map.get(rec[1]).add(rec[0]);
        }
        for (int y : map.keySet()) {
            Collections.sort(map.get(y));
        }
        int n = points.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            for (int j = y; j <= 100; j++) {
                if (map.containsKey(j)) {
                    List<Integer> list = map.get(j);
                    res[i] += list.size() - binarySearch(x, list);
                }
            }
        }
        return res;
    }
    /**
     * List中找出 < tar 的元素数量
     */
    public int binarySearch(int tar, List<Integer> list) {
        int sz = list.size();
        if (tar > list.get(sz - 1)) {
            return sz;
        }
        int l = 0, r = sz - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (list.get(mid) < tar) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
