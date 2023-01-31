package haiwaitu.t20220707;

/**
 * @Author huangjunqiao
 * @Date 2022/07/07 17:10
 * @Description 36. 有效的数独
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // board的长宽都算常数，时间：O(1)，空间：O(1)。
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] subSquare = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int num = c - '0' - 1;
                if (rows[i][num] != 0 || cols[j][num] != 0 || subSquare[i / 3][j / 3][num] != 0) {
                    return false;
                }
                rows[i][num]++;
                cols[j][num]++;
                subSquare[i / 3][j / 3][num]++;
            }
        }
        return true;
    }
}
