package haiwaitu.t20210614;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author huangjunqiao
 * @Date 2021/06/15 08:43
 * @Description 718. 最长重复子数组
 */
public class FindLength {
     public int findLength1(int[] nums1, int[] nums2) {
         // 动态规划，时间O(M*N),空间O(M*N)
         int max = 0;
         int m = nums1.length, n = nums2.length;
         int[][] dp = new int[m + 1][n + 1];
         for (int i = m - 1; i >= 0; i--) {
             for (int j = n - 1; j >= 0; j--) {
                 dp[i][j] = nums1[i] == nums2[j] ? 1 + dp[i + 1][j + 1] : 0;
                 max = Math.max(max, dp[i][j]);
             }
         }
         return max;
     }

     public int findLength2(int[] nums1, int[] nums2) {
         // 滑动窗口解法，时间O((M+N)*min(N,M))，空间O(1)
         int max = 0, currMax = 0;
         int m = nums1.length, n = nums2.length;
         for (int i = 0; i < m; i++) {
             currMax = extendWindown(nums1, nums2, i, 0, Math.min(m - i, n));
             max = Math.max(max, currMax);
         }
         for (int i = 0; i < n; i++) {
             currMax = extendWindown(nums1, nums2, 0, i, Math.min(m, n - i));
             max = Math.max(max, currMax);
         }
         return max;
     }
     public int extendWindown(int[] nums1, int[] nums2, int idx1, int idx2, int len) {
         // 固定一个数组的起点元素，逐个与另一个数组的所有元素对比，相同则作为滑动窗口的起点
         int max = 0, currMax = 0;
         for (int wdLen = 0; wdLen < len; wdLen++) {
             if (nums1[idx1 + wdLen] == nums2[idx2 + wdLen]) {
                 currMax++;
             } else {
                 currMax = 0;
             }
             max = Math.max(max, currMax);
         }
         return max;
     }

    int mod = 1000000009;
    int base = 113;
    public int findLength0(int[] A, int[] B) {
        // 二分+哈希解法，时间O((N+M)log(min(N,M)))，空间O(M)
        int left = 1, right = Math.min(A.length, B.length) + 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(A, B, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    public boolean check(int[] A, int[] B, int len) {
        long hashA = 0;
        for (int i = 0; i < len; i++) {
            hashA = (hashA * base + A[i]) % mod;
        }
        Set<Long> bucketA = new HashSet<Long>();
        bucketA.add(hashA);
        long mult = qPow(base, len - 1);
        for (int i = len; i < A.length; i++) {
            hashA = ((hashA - A[i - len] * mult % mod + mod) % mod * base + A[i]) % mod;
            bucketA.add(hashA);
        }
        long hashB = 0;
        for (int i = 0; i < len; i++) {
            hashB = (hashB * base + B[i]) % mod;
        }
        if (bucketA.contains(hashB)) {
            return true;
        }
        for (int i = len; i < B.length; i++) {
            hashB = ((hashB - B[i - len] * mult % mod + mod) % mod * base + B[i]) % mod;
            if (bucketA.contains(hashB)) {
                return true;
            }
        }
        return false;
    }

    // 使用快速幂计算 x^n % mod 的值
    public long qPow(long x, long n) {
        long ret = 1;
        while (n != 0) {
            if ((n & 1) != 0) {
                ret = ret * x % mod;
            }
            x = x * x % mod;
            n >>= 1;
        }
        return ret;
    }
}
