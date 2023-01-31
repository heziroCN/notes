package haiwaitu.t20220728;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author huangjunqiao
 * @Date 2022/07/28 22:46
 * @Description 994. 腐烂的橘子
 */
public class OrangeRotting {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        // 多源BFS，时间：O(mn)，空间：O(mn)，用时：23min
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }
        int minute = 0;
        while (!q.isEmpty()) {
            boolean needTime = false;
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] arr = q.poll();
                for (int[] d : directions) {
                    int x = arr[0] + d[0], y = arr[1] + d[1];
                    if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                        needTime = true;
                        grid[x][y] = 2;
                        q.offer(new int[] {x, y});
                    }
                }
            }
            if (needTime) {
                minute++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return minute;
    }
}
