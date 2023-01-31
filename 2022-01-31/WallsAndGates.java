package haiwaitu.t20220131;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2022/02/01 23:19
 * @Description 286. 墙与门
 */
public class WallsAndGates {
    static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] {-1, 0},
            new int[] {1, 0},
            new int[] {0, -1},
            new int[] {0, 1}
    );
    static final int INF = Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        // 从起点出发的BFS，时间：O((mn)^2)，空间：O(mn)
        int m = rooms.length, n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == INF) {
                    rooms[i][j] = nearestGate(rooms, i, j);
                }
            }
        }
    }
    public int nearestGate(int[][] rooms, int i, int j) {
        int m = rooms.length, n = rooms[0].length;
        int[][] distant = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0], y = pos[1];
            for (int[] direction : DIRECTIONS) {
                int newx = x + direction[0], newy = y + direction[1];
                if (newx < 0 || newy < 0 || newx >= m || newy >= n || rooms[newx][newy] == -1 || distant[newx][newy] != 0) {
                    continue;
                }
                if (rooms[newx][newy] == 0) {
                    return distant[x][y] + 1;
                }
                distant[newx][newy] = distant[x][y] + 1;
                q.offer(new int[] {newx, newy});
            }
        }
        return Integer.MAX_VALUE;
    }

    public void wallsAndGates0(int[][] rooms) {
        // 从终点出发的BFS，时间：O(mn)，空间：O(mn)
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0], y = pos[1];
            for (int[] direction : DIRECTIONS) {
                int newx = x + direction[0], newy = y + direction[1];
                if (newx < 0 || newy < 0 || newx >= m || newy >= n || rooms[newx][newy] != INF) {
                    continue;
                }
                rooms[newx][newy] = rooms[x][y] + 1;
                q.offer(new int[] {newx, newy});
            }
        }
    }
}
