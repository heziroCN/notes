package haiwaitu.t20211023;

/**
 * @Author huangjunqiao
 * @Date 2021/10/24 19:48
 * @Description 695. 岛屿的最大面积
 */
public class MaxAreaOfIslands {
    int m;
    int n;
    public int maxAreaOfIsland0(int[][] grid) {
        // dfs解法
        int maxArea = 0;
        int currArea = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    currArea = dfs(i, j, grid);
                }
                maxArea = Math.max(maxArea, currArea);
            }
        }

        return maxArea;
    }
    public int dfs(int row, int col, int[][] grid) {
        if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == 0) {
            return 0;
        }
        int currArea = 1;
        grid[row][col] = 0;
        currArea += dfs(row + 1, col, grid);
        currArea += dfs(row - 1, col, grid);
        currArea += dfs(row, col + 1, grid);
        currArea += dfs(row, col - 1, grid);
        return currArea;
    }

    class UnionFind {
        int[] parent;
        int[] rank;
        public int[] areas;

        public UnionFind(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            areas = new int[m * n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        parent[i * n + j] = i * n + j;
                        areas[i * n + j] = 1;
                    }
                }
            }
        }

        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return find(parent[x]);
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx == rooty) {
                return;
            }
            if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
                areas[rooty] += areas[rootx];
            } else if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
                areas[rootx] += areas[rooty];
            } else {
                parent[rooty] = rootx;
                rank[rootx]++;
                areas[rootx] += areas[rooty];
            }
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        // 并查集
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        uf.union(i * n + j, (i + 1) * n + j);
                    }
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        uf.union(i * n + j, i * n + j + 1);
                    }
                }
            }
        }
        int max = 0;
        for (int area : uf.areas) {
            max = Math.max(max, area);
        }
        return max;
    }
}
