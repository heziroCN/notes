package haiwaitu.t20210828;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author huangjunqiao
 * @Date 2021/08/28 05:42
 * @Description 378. 有序矩阵中第 K 小的元素
 */
public class KthSmallest {
    // 类似题目：240. 搜索二维矩阵 II
    public int kthSmallest(int[][] matrix, int k) {
        // 借助堆的归并排序，时间：O(klogN)，空间：O(N)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] a, int[] b) {
                        return a[0] - b[0];
                    }
                }
        );
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});// 初始化，存储每行的第一个数及其的坐标
        }
        for (int i = 0; i < k - 1; i++) {
            int[] curr = pq.poll();
            if (curr[2] != n - 1) {
                pq.offer(new int[]{matrix[curr[1]][curr[2] + 1], curr[1], curr[2] + 1});
            }
        }
        return pq.poll()[0];
    }

    public int kthSmallest0(int[][] matrix, int k) {
        // 二分查找，时间：O(Nlog(r-l))，空间：O(1)。（l，r为矩阵中的最小数和最大数）
        int n = matrix.length;
        int l = matrix[0][0], r = matrix[n - 1][n - 1];
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(matrix, n, mid, k)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    public boolean check(int[][] matrix, int n, int mid, int k) {
        // 从右上角开始向左下搜索，并统计小于mid的个数
        int num = 0;
        int i = 0, j = n - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] <= mid) {
                i++;
                num += j + 1;// 统计当前行符合前k小的数
            } else {
                j--;// 到下一行继续统计
            }
        }
        return num < k;
    }
}
