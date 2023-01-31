package haiwaitu.t20221003;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2022/10/03 20:51
 * @Description 54. 螺旋矩阵
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 模拟，时间：O(n)，空间：O(1)
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int left = 0, right = n - 1, top = 0, buttom = m - 1;
        while (left <= right && top <= buttom) {
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            for (int i = top + 1; i <= buttom; i++) {
                res.add(matrix[i][right]);
            }
            if (top < buttom) {
                for (int j = right - 1; j >= left; j--) {
                    res.add(matrix[buttom][j]);
                }
            }
            if (left < right) {
                for (int i = buttom - 1; i > top; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            buttom--;
        }
        return res;
    }

}
