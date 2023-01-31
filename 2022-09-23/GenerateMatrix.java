package haiwaitu.t20220923;

/**
 * @Author huangjunqiao
 * @Date 2022/09/23 13:21
 * @Description 59. 螺旋矩阵 II
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        // 时间：O(n)，空间：O(1)，用时：13min
        int[][] arr = new int[n][n];
        int curr = 1;
        int left = 0, right = n - 1, top = 0, buttom = n - 1;
        while (left <= right || top <= buttom) {
            for (int j = left; j <= right; j++) {
                arr[top][j] = curr++;
            }
            for (int i = top + 1; i <= buttom; i++) {
                arr[i][right] = curr++;
            }
            if (top < buttom) {
                for (int j = right - 1; j > left; j--) {
                    arr[buttom][j] = curr++;
                }
                for (int i = buttom; i > top; i--) {
                    arr[i][left] = curr++;
                }
            }
            left++;
            right--;
            top++;
            buttom--;
        }
        return arr;
    }
}
