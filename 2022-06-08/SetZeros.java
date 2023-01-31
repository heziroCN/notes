package haiwaitu.t20220608;

/**
 * @Author huangjunqiao
 * @Date 2022/06/08 17:07
 * @Description 73. 矩阵置零
 */
public class SetZeros {
    public void setZeroes(int[][] matrix) {
        // 两个标量标记，时间：O(mn)，空间：O(1)
        boolean firstRow0 = false, firstCol0 = false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstCol0 = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRow0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public void setZeroes0(int[][] matrix) {
        // 一个标量标记，时间：O(mn)，空间：O(1)
        int m = matrix.length, n = matrix[0].length;
        boolean firstCol0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstCol0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (firstCol0) {
                matrix[i][0] = 0;
            }
        }
    }
}
