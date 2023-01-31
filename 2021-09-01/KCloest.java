package haiwaitu.t20210901;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Author huangjunqiao
 * @Date 2021/09/01 13:15
 * @Description 973. 最接近原点的 K 个点
 */
public class KCloest {
    // 相似题目：347. 前 K 个高频元素
    public int[][] kClosest(int[][] points, int k) {
        // 堆，时间：O(Nlogk)，空间：O(k)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                new Comparator<int[]>() {
                    public int compare(int[] a, int[] b) {
                        int x1 = a[0], y1 = a[1];
                        int x2 = b[0], y2 = b[1];
                        return x2 * x2 + y2 * y2 - x1 * x1 - y1 * y1;
                    }
                }
        );
        int len = points.length;
        for (int i = 0; i < len; i++) {
            pq.offer(points[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    Random rand = new Random();
    public int[][] kClosest0(int[][] points, int k) {
        // 快排思想，时间：平均O(N)，最坏情况每次都选取最大或最小值作为枢纽，O(N^2)，空间：平均O(logN)，最坏O(N)
        partition(points, k, 0, points.length - 1);
        return Arrays.copyOfRange(points, 0, k);
    }
    public void partition(int[][] points, int k, int start, int end) {
        int pivot = start + rand.nextInt(end - start + 1);
        int pivotDist = points[pivot][0] * points[pivot][0] + points[pivot][1] * points[pivot][1];
        int idx = start;
        swap(points, pivot, end);
        for (int i = start; i < end; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (dist <= pivotDist) {
                swap(points, idx, i);
                idx++;
            }
        }
        swap(points, idx, end);
        // 得到了(idx-start+1)个<=pivot的元素，
        if (idx - start + 1 > k) {
            // 如果idx-start+1 > k，从[start,idx-1]内继续搜索k个元素即可。
            partition(points, k, start, idx - 1);
        } else if (idx - start + 1 < k) {
            // 如果idx-start+1 < k，[start, idx]可以作为答案的一部分。答案剩下的(k-(idx-start+1))个元素，在[idx+1, end]内继续搜索
            partition(points, k - (idx - start + 1), idx + 1, end);
        }
    }
    public void swap(int[][] a, int x, int y) {
        int[] temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
