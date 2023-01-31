package haiwaitu.t20230102;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2023/01/02 16:42
 * @Description 51. N 皇后
 */
public class SolveNQueens {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        // 时间：O(n!)，空间：O(n)
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        backtrack(columns, diagonals1, diagonals2, queens, n, 0);
        return res;
    }

    public void backtrack(Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2, int[] queens, int n, int row) {
        if (row == n) {
            res.add(generateBoard(queens, n));
            return;
        }
        for (int j = 0; j < n; j++) {
            int diagonal1 = row - j, diagonal2 = row + j;
            if (columns.contains(j) || diagonals1.contains(diagonal1) || diagonals2.contains(diagonal2)) {
                continue;
            }
            queens[row] = j;
            columns.add(j);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            backtrack(columns, diagonals1, diagonals2, queens, n, row + 1);
            queens[row] = -1;
            columns.remove(j);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == queens[i]) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        return list;
    }


    public List<List<String>> solveNQueens0(int n) {
        // 时间：O(n!)，空间：O(n)
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        solve(queens, 0, 0, 0, 0, n);
        return res;
    }

    public void solve(int[] queens, int columns, int diagonals1, int diagonals2, int row, int n) {
        if (row == n) {
            res.add(generateBoard(queens, n));
            return;
        }
        // 1、找到可用位置
        int availablePos = ((1 << n) - 1) & (~((columns | diagonals1 | diagonals2)));
        while (availablePos != 0) {
            // 2、取出最低位的1（位置），将最低位的1置0
            int pos = availablePos & (-availablePos);
            availablePos &= (availablePos - 1);
            // 3、将这个1与三个记录皇后的二进制数字按位或
            int col = Integer.bitCount(pos - 1);
            queens[row] = col;
            solve(queens, columns | pos, (diagonals1 | pos) << 1, (diagonals2 | pos) >> 1, row + 1, n);
            queens[row] = -1;
        }
    }

}
