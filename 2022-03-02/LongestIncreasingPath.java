package haiwaitu.t20220302;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2022/03/02 22:59
 * @Description 329. 矩阵中的最长递增路径
 */
public class LongestIncreasingPath {
    int[][] direc = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    public int longestIncreasingPath(int[][] matrix) {
        // 记忆化DFS，时间：O(mn)，空间：O(mn)
        m = matrix.length;
        n = matrix[0].length;
        int[][] memo = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(i, j, matrix, memo));
            }
        }
        return res;
    }
    public int dfs(int i, int j, int[][] matrix, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        memo[i][j]++;
        for (int[] d : direc) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] > matrix[i][j]) {
                memo[i][j] = Math.max(memo[i][j], dfs(x, y, matrix, memo) + 1);
            }
        }
        return memo[i][j];
    }

    public int longestIncreasingPath0(int[][] matrix) {
        // 拓扑排序，时间：O(mn)，空间：O(mn)
        m = matrix.length;
        n = matrix[0].length;
        int[][] outdegree = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] d : direc) {
                    int x = i + d[0], y = j + d[1];
                    if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] > matrix[i][j]) {
                        outdegree[i][j]++;
                    }
                }
            }
        }
        Deque<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (outdegree[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }
        int res = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            res++;
            for (int i = 0; i < sz; i++) {
                int[] p = q.poll();
                for (int[] d : direc) {
                    int x = p[0] + d[0], y = p[1] + d[1];
                    if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] < matrix[p[0]][p[1]]) {
                        outdegree[x][y]--;
                        if (outdegree[x][y] == 0) {
                            q.offer(new int[] {x, y});
                        }
                    }
                }
            }
        }
        return res;
    }
}
