package haiwaitu.t20220310;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2022/03/11 02:03
 * @Description 1504. 统计全 1 子矩形
 */
public class NumSubmat {
     public int numSubmat(int[][] mat) {
         // 枚举，时间：O(nm^2)，空间：O(mn)
         int m = mat.length, n = mat[0].length;
         int[][] row = new int[m][n];// (i,j)左边的“1”的个数
         for (int i = 0; i < m; i++) {
             for (int j = 0; j < n; j++) {
                 if (j == 0) {
                     row[i][j] = mat[i][j];
                 } else if (mat[i][j] == 0) {
                     row[i][j] = 0;
                 } else {
                     row[i][j] = row[i][j - 1] + 1;
                 }
             }
         }
         int res = 0;
         for (int i = 0; i < m; i++) {
             for (int j = 0; j < n; j++) {
                 int curr = row[i][j];// 当前行为顶边，以(i,j)为右下角的矩形
                 for (int k = i; k >= 0 && row[k][j] != 0; k--) {
                     curr = Math.min(curr, row[k][j]);
                     res += curr;
                 }
             }
         }
         return res;
     }

    public int numSubmat0(int[][] mat) {
        // 单调栈优化枚举的重复计算，时间：O(mn)，空间：O(mn)
        int m = mat.length, n = mat[0].length;
        int[][] row = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    row[i][j] = mat[i][j];
                } else if (mat[i][j] == 0) {
                    row[i][j] = 0;
                } else {
                    row[i][j] = row[i][j - 1] + 1;
                }
            }
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            int sum = 0;
            Deque<int[]> stk = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                int height = 1;
                while (!stk.isEmpty() && row[i][j] < stk.peek()[0]) {
                    int[] arr = stk.pop();
                    sum -= arr[1] * (arr[0] - row[i][j]);
                    height += arr[1];
                }
                sum += row[i][j];
                res += sum;
                stk.push(new int[] {row[i][j], height});
            }
        }
        return res;
    }
}
