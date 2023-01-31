package haiwaitu.t20220424;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2022/04/25 00:43
 * @Description 6044. 花期内花的数目
 */
public class FullBloomFlowers {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        // 排序+二分，时间：O(sort(m) + nlogm)，空间：O(m)，m为花数量，n为游客数量
        int m = flowers.length, n = persons.length;
        int[] start = new int[m], end = new int[m];
        for (int i = 0; i < m; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int startNum = upperBound(start, persons[i]) + 1;
            int endNum = lowerBound(end, persons[i]) + 1;
            res[i] = startNum - endNum;
        }
        return res;
    }
    // < tar的最大下标
    public int lowerBound(int[] nums, int tar) {
        if (nums[0] >= tar) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (nums[mid] >= tar) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }
    // <= tar的最大下标
    public int upperBound(int[] nums, int tar) {
        if (nums[0] > tar) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (nums[mid] > tar) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }
}
