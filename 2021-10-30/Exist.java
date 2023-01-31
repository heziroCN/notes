package haiwaitu.t20211030;

/**
 * @Author huangjunqiao
 * @Date 2021/10/30 17:57
 * @Description 79. 单词搜索
 */
public class Exist {
    public int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        // 时间：O(MN*3^S)，空间：O(MN)，S为word长度
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(i, j, board, visited, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(int row, int col, char[][] board, boolean[][] visited, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(idx)) {
            return false;
        }

        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {// 向4个方向访问
            int x = row + direction[i][0], y = col + direction[i][1];
            if (backtrack(x, y, board, visited, word, idx + 1)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}
