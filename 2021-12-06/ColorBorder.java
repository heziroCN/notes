package haiwaitu.t20211206;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author huangjunqiao
 * @Date 2021/12/07 23:50
 * @Description 1034. 边界着色
 */
public class ColorBorder {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        // dfs， 时间：O(MN)，空间：O(MN)
        List<int[]> needPaints = new ArrayList<>();//边遍历边着色会影响其他递归分支的判断，先缓存后续统一着色
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(row, col, grid[row][col], grid, needPaints, visited);

        for (int[] area : needPaints) {
            grid[area[0]][area[1]] = color;
        }
        return grid;
    }
    public void dfs(int x, int y, int origColor, int[][] grid, List<int[]> needPaints, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        visited[x][y] = true;
        boolean isBorder = false;
        int[][] step = {{-1, 0}, {1, 0}, {0, -1} , {0, 1}};
        for (int i = 0; i < 4; i++) {
            int nx = x + step[i][0], ny = y + step[i][1];
            if (!(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == origColor)) {
                isBorder = true;
            } else if (!visited[nx][ny]) {
                dfs(nx, ny, origColor, grid, needPaints, visited);
            }
        }
        if (isBorder) {
            needPaints.add(new int[] {x, y});
        }
    }


    public int[][] colorBorder0(int[][] grid, int row, int col, int color) {
        // bfs，思路同dfs，时间：O(MN)，空间：O(MN)
        int m = grid.length, n = grid[0].length;
        List<int[]> needPaints = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        int[][] step = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {row, col});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            visited[x][y] = true;
            boolean isBorder = false;
            for (int i = 0; i < 4; i++) {
                int nx = x + step[i][0], ny = y + step[i][1];
                if (!(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == grid[row][col])) {
                    isBorder = true;
                } else if (!visited[nx][ny]) {
                    q.offer(new int[] {nx, ny});
                }
            }
            if (isBorder) {
                needPaints.add(new int[] {x, y});
            }
        }
        for (int[] area : needPaints) {
            grid[area[0]][area[1]] = color;
        }
        return grid;
    }
}
