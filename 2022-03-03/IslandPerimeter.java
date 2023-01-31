package haiwaitu.t20220303;

/**
 * @Author huangjunqiao
 * @Date 2022/03/04 17:42
 * @Description 463. 岛屿的周长
 */
public class IslandPerimeter {
    int[][] direc = {{1 ,0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    public int islandPerimeter(int[][] grid) {
        // 循环遍历，时间：O(mn)，空间：O(1)
        int res = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                for (int[] d : direc) {
                    int x = i + d[0], y = j + d[1];
                    if (x == m || x == -1 || y == n || y == -1 || grid[x][y] == 0) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public int islandPerimeter0(int[][] grid) {
        // DFS，时间：O(mn)，空间：O(mn)
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }
    public int dfs(int[][] grid, int i, int j) {
        if (i == -1 || i == m || j == -1 || j == n || grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == 2) {
            return 0;
        }
        grid[i][j] = 2;
        int cnt = 0;
        for (int[] d : direc) {
            int x = i + d[0], y = j + d[1];
            cnt += dfs(grid, x, y);
        }
        return cnt;
    }
}
