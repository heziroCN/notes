package haiwaitu.t20220301;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author huangjunqiao
 * @Date 2022/03/02 12:02
 * @Description 490. 迷宫
 */
public class HashPath {
    int[][] direc = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // 时间：O(mn)，空间：O(mn)
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        q.offer(start);
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            if (p[0] == destination[0] && p[1] == destination[1]) {
                return true;
            }
            for (int[] d : direc) {
                int x = p[0] + d[0], y = p[1] + d[1];
                while (x >= 0 && y >= 0 && x < m && y < n && maze[x][y] != 1) {
                    x += d[0];
                    y += d[1];
                }
                if (!visited[x - d[0]][y - d[1]]) {
                    q.offer(new int[] {x - d[0] ,y - d[1]});
                    visited[x - d[0]][y - d[1]] = true;
                }
            }
        }
        return false;
    }
}
