package haiwaitu.t20220605;

/**
 * @Author huangjunqiao
 * @Date 2022/06/05 18:18
 * @Description 348. 设计井字棋
 */
public class TicTacToe {
    int[] cols;
    int[] rows;
    int sz;
    int diagonal, reverseDiagonal;
    // 时间：均摊move为O(1)，空间：O(n)
    public TicTacToe(int n) {
        this.sz = n;
        cols = new int[n];
        rows = new int[n];
    }

    public int move(int row, int col, int player) {
        int add = player == 1 ? 1 : -1;
        rows[row] += add;
        cols[col] += add;
        if (row == col) {
            diagonal += add;
        }
        if (col == sz - 1 - row) {
            reverseDiagonal += add;
        }
        if (Math.abs(rows[row]) == sz || Math.abs(cols[col]) == sz || Math.abs(diagonal) == sz || Math.abs(reverseDiagonal) == sz) {
            return player;
        }
        return 0;
    }
}
