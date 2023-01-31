package haiwaitu.t20220715;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2022/07/17 17:59
 * @Description 37. 解数独
 */
public class SolveSudoku {
    // boolean[][] rows = new boolean[9][9], cols = new boolean[9][9];
    // boolean[][][] blocks = new boolean[3][3][9];
    // boolean found = false;
    // List<int[]> dots = new ArrayList<>();
    // public void solveSudoku(char[][] board) {
    //     // 回溯，用时：没写完
    //     for (int i = 0; i < 9; i++) {
    //         for (int j = 0; j < 9; j++) {
    //             char c = board[i][j];
    //             if (c != '.') {
    //                 int num = c - '0' - 1;
    //                 rows[i][num] = cols[j][num] = blocks[i / 3][j / 3][num] = true;
    //             } else {
    //                 dots.add(new int[] {i, j});
    //             }
    //         }
    //     }
    //     backtrack(board, 0);
    // }
    // public void backtrack(char[][] board, int idx) {
    //     if (idx == dots.size()) {
    //         found = true;
    //         return;
    //     }
    //     int i = dots.get(idx)[0], j = dots.get(idx)[1];
    //     for (int num = 0; num < 9 && !found; num++) {
    //         if (rows[i][num] || cols[j][num] || blocks[i / 3][j / 3][num]) {
    //             continue;
    //         }
    //         board[i][j] = (char) (num + '0' + 1);
    //         rows[i][num] = cols[j][num] = blocks[i / 3][j / 3][num] = true;
    //         backtrack(board, idx + 1);
    //         rows[i][num] = cols[j][num] = blocks[i / 3][j / 3][num] = false;
    //     }
    // }

    int[] rows = new int[9], cols = new int[9];
    int[][] blocks = new int[3][3];
    List<int[]> dots = new ArrayList<>();
    boolean valid = false;
    public void solveSudoku0(char[][] board) {
        // 用时：24min
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    dots.add(new int[] {i, j});
                } else {
                    flip(i, j, board[i][j] - '0' - 1);// 这里取反即置'1'
                }
            }
        }
        dfs(0, board);
    }

    public void dfs(int idx, char[][] board) {
        if (idx == dots.size()) {
            valid = true;
            return;
        }
        int[] dot = dots.get(idx);
        // 找最低位的0不方便，取反改为找最低位的1
        int i = dot[0], j = dot[1];
        int mask = ~(rows[i] | cols[j] | blocks[i / 3][j / 3]) & 0x1ff;
        for (; mask != 0 && !valid; mask &= (mask - 1)) {
            int lowest1 = mask & (-mask);
            int num = Integer.bitCount(lowest1 - 1);
            flip(i, j, num);// 这里取反即置'1'
            board[i][j] = (char) (num + '0' + 1);
            dfs(idx + 1, board);
            flip(i, j, num);// 这里取反即置'0'
        }
    }

    public void flip(int i, int j, int num) {
        rows[i] ^= (1 << num);
        cols[j] ^= (1 << num);
        blocks[i / 3][j / 3] ^= (1 << num);
    }
    public void solveSudoku1(char[][] board) {
        while (true) {
            boolean modified = false;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        continue;
                    }
                    int mask = ~(rows[i] | cols[j] | blocks[i / 3][j / 3]) & 0x1ff;
                    if ((mask & (mask - 1)) == 0) {
                        int lowest1 = mask & (-mask);
                        int num = Integer.bitCount(lowest1 - 1);
                        flip(i, j, num);
                        board[i][j] = (char) (num + '0' + 1);
                        modified = true;
                    }
                }
            }
            if (!modified) {
                break;
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    dots.add(new int[] {i, j});
                } else {
                    flip(i, j, board[i][j] - '0' - 1);
                }
            }
        }
        dfs(0, board);
    }
}
