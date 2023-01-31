package haiwaitu.t20210610;

/**
 * @Author huangjunqiao
 * @Date 2021/06/11 03:31
 * @Description 74. 搜索二维矩阵
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 二分解法，时间O(log(MN))，空间O(1)
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            int curr = matrix[mid / n][mid % n];
            if (curr == target) {
                return true;
            } else if (curr < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    // public boolean searchMatrix(int[][] matrix, int target) {
    //     // 精准搜索 时间O(M+N)，空间O(1)
    //     if (matrix == null || matrix.length == 0) {
    //         return false;
    //     }
    //     int row = matrix.length - 1;
    //     int col = 0;
    //     while (row >= 0 && col < matrix[0].length) {
    //         if (matrix[row][col] > target) {
    //             row--;
    //         } else if (matrix[row][col] < target) {
    //             col++;
    //         } else {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}
