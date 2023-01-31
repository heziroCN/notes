package haiwaitu.t20220109;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author huangjunqiao
 * @Date 2022/01/10 22:13
 * @Description 406. 根据身高重建队列
 */
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        // 时间：O(n^2)，空间：O(n)
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[0] != p2[0]) {
                    return p1[0] - p2[0];
                } else {
                    return p2[1] - p1[1];
                }
            }
        });
        int n = people.length;
        int[][] res = new int[n][];
        for (int[] arr : people) {
            int slot = arr[1] + 1;
            for (int i = 0; i < n; i++) {
                if (res[i] == null) {
                    slot--;
                    if (slot == 0) {
                        res[i] = arr;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
