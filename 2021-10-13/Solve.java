package haiwaitu.t20211013;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/10/14 00:12
 * @Description 130. 被围绕的区域
 */
public class Solve {
    int m;
    int n;
    public void solve(char[][] board) {
        // dfs，从四条边上的每个点出发，标记与边界'O'能延伸得到的'O'，每个点只标记一次，时间：O(mn)，空间：O(mn)
        m = board.length;
        n = board[0].length;
        // 1、从四条边的每个点出发，标记所有点
        for (int i = 0; i < m; i++) {
            dfs(i, 0, board);
            dfs(i, n - 1, board);
        }
        for (int j = 1; j < n - 1; j++) {
            dfs(0, j, board);
            dfs(m - 1, j, board);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'M') {
                    board[i][j] = 'O';//被标记的都是从边界'O'延伸而来的，需要恢复为'O'
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int row, int col, char[][] board) {
        if (row < 0 || col < 0 || row >= m || col >= n || board[row][col] != 'O') {
            return;// 不是从边界'O'延伸而来的，第一次递归在这里就返回了。也不会有之后的标记
        }
        board[row][col] = 'M';
        dfs(row + 1, col, board);
        dfs(row - 1, col, board);
        dfs(row, col + 1, board);
        dfs(row, col - 1, board);
    }

    public void solve0(char[][] board) {
        // bfs，与bfs一样从四条边的每个点出发，标记与边界'O'能延伸得到的'O'，每个点标记一次，最多出入队列一次，时间：O(mn)，空间：O(mn)
        Deque<int[]> q = new LinkedList<>();
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                q.offer(new int[] {i, 0});
                board[i][0] = 'M';
            }
            if (board[i][n - 1] == 'O') {
                q.offer(new int[] {i, n - 1});
                board[i][n - 1] = 'M';
            }
        }
        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O') {
                q.offer(new int[] {0, j});
                board[0][j] = 'M';
            }
            if (board[m - 1][j] == 'O') {
                q.offer(new int[] {m - 1, j});
                board[m - 1][j] = 'M';
            }
        }

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];
            moveAndMark(x, y + 1, board, q);
            moveAndMark(x, y - 1, board, q);
            moveAndMark(x + 1, y, board, q);
            moveAndMark(x - 1, y, board, q);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'M') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void moveAndMark(int x, int y, char[][] board, Deque<int[]> q) {
        if (x < 0 || y < 0 || x >= m || y >= n || board[x][y] != 'O') {
            return;
        }
        q.offer(new int[] {x, y});
        board[x][y] = 'M';
    }

}
