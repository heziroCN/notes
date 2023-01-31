package haiwaitu.t20210510;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/05/10 03:09
 * @Description  48. 旋转图像
 */
public class Rotate {
    /**
     * 直接旋转 时间O(N^2) 空间O(1)
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        // 顺时针转90°后，新的坐标映射公式：matrix[i][j]=>matrix[j][n-i]
        int n = matrix.length;
        // 在原矩阵上旋转，需要缓存一个数字来腾出位置
        // 对于偶数长度矩阵，可以将矩阵四等分分成4个小矩形，枚举n/2 * n/2；
        // 奇数长度矩形中心位置不需要改变，枚举n/2 * (n+1)/2
        int temp;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

    /**
     * 水平翻转+主对角线翻转 时间O(N^2) 空间O(1)
     * @param matrix
     */
    public void rotate0(int[][] matrix) {
        // 新的坐标映射公式：matrix[i][j]=>matrix[j][n-1-i]
        // 水平翻转映射公式：matrix[i][j]=>matrix[n-1-i][j]
        // 主对角线翻转映射：matrix[i][j]=>matrix[j][i]，
        // matrix[i][j]可以由水平翻转+主对角线翻转得到matrix[j][n-1-i]
        int n = matrix.length;
        int temp;
        // 水平翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
