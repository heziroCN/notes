package haiwaitu.t20210612;

/**
 * @Author huangjunqiao
 * @Date 2021/06/12 22:47
 * @Description 240. 搜索二维矩阵 II
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
    // 二分解法 沿对角线进行二分搜索。时间logN+log(N-1)+...+log2+log1=log(N(N-1)(N-2)...*2*1)，即O(log(N!))，空间O(1)
    int shorterDim = Math.min(matrix.length, matrix[0].length);
    for (int i = 0; i < shorterDim; i++) {
        boolean verticalFound = binarySearch(matrix, target, i, true);
        boolean horizontalFound = binarySearch(matrix, target, i, false);
        if (verticalFound || horizontalFound) {
            return true;
        }
    }
    return false;
}
    public boolean binarySearch(int[][] matrix, int target, int start, boolean verticle) {
        // 在最右一列找到第一个大于target的元素
        int lo = start;
        int hi = verticle ?  matrix[0].length - 1 : matrix.length - 1;
        int mid = 0;
        if (verticle) {
            // 横向搜索
            while (lo <= hi) {
                mid = (lo + hi) >> 1;
                if (matrix[start][mid] < target) {
                    lo = mid + 1;
                } else if (matrix[start][mid] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            }
        } else {
            // 纵向搜搜
            while (lo <= hi) {
                mid = (lo + hi) >> 1;
                if (matrix[mid][start] < target) {
                    lo = mid + 1;
                } else if (matrix[mid][start] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

     public boolean searchMatrix0(int[][] matrix, int target) {
         // 精准搜索，从右上角开始搜索，比target小则向下移动，比target大则向左移动。时间O(M+N)，空间O(1)
         int m = matrix.length, n = matrix[0].length;
         int row = 0, col = n - 1;
         while (row < m && col >= 0) {
             if (matrix[row][col] == target) {
                 return true;
             } else if (matrix[row][col] < target) {
                 row++;
             } else {
                 col--;
             }
         }
         return false;
     }

}
