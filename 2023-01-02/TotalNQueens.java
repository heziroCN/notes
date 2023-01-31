package haiwaitu.t20230102;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author huangjunqiao
 * @Date 2023/01/03 11:13
 * @Description 52. N皇后 II
 */
public class TotalNQueens {
     public int totalNQueens(int n) {
         // 时间：O(n!)，空间：O(n)
         Set<Integer> columns = new HashSet<>(), diagonals1 = new HashSet<>(), diagonals2 = new HashSet<>();
         return backtrack(0, n, columns, diagonals1, diagonals2);
     }
     public int backtrack(int row, int n, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
         if (row == n) {
             return 1;
         }
         int cnt = 0;
         for (int j = 0; j < n; j++) {
             int diag1 = row - j, diag2 = row + j;
             if (columns.contains(j) || diagonals1.contains(diag1) || diagonals2.contains(diag2)) {
                 continue;
             }
             columns.add(j);
             diagonals1.add(diag1);
             diagonals2.add(diag2);
             cnt += backtrack(row + 1, n, columns, diagonals1, diagonals2);
             columns.remove(j);
             diagonals1.remove(diag1);
             diagonals2.remove(diag2);
         }
         return cnt;
     }

    public int totalNQueens0(int n) {
        // 时间：O(n!)，空间：O(n)
        return backtrack(0, n, 0, 0, 0);
    }
    public int backtrack(int row, int n, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            return 1;
        }
        int cnt = 0;
        // 找出所有可落子的位置
        int availablePos = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
        while (availablePos != 0) {
            // 取出最低位1
            int pos = availablePos & (-availablePos);
            // 去掉最低位1
            availablePos &= (availablePos - 1);
            cnt += backtrack(row + 1, n, columns | pos, (diagonals1 | pos) << 1, (diagonals2 | pos) >> 1);
        }
        return cnt;
    }
}
