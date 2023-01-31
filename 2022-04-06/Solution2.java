package haiwaitu.t20220406;

import java.util.Random;

/**
 * @Author huangjunqiao
 * @Date 2022/04/07 17:36
 * @Description 528. 按权重随机选择
 */
public class Solution2 {
    int[] prefix;
    int sum;
    Random rand = new Random();
    public Solution2(int[] w) {
        // 前缀和+二分，时间：初始化O(n)，二分查找O(logn)，空间：O(n)
        int n = w.length;
        prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + w[i];
        }
        sum = prefix[n];
    }

    public int pickIndex() {
        int num = rand.nextInt(sum) + 1;
        return binarySearch(num) - 1;
    }
    public int binarySearch(int tar) {
        int l = 1, r = prefix.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (prefix[mid] >= tar) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
