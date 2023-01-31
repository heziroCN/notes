package haiwaitu.t20220402;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2022/04/03 22:16
 * @Description 526. 优美的排列
 */
public class CountArrangement {
     boolean[] vis;
     List<Integer>[] match;
     int res;
     public int countArrangement(int n) {
         // 回溯，时间：O(n!)，空间：O(n^2)
         vis = new boolean[n + 1];
         match = new List[n + 1];
         for (int i = 1; i <= n; i++) {
             match[i] = new ArrayList<>();
             for (int j = 1; j <= n; j++) {
                 if (i % j == 0 || j % i == 0) {
                     match[i].add(j);
                 }
             }
         }
         backtrack(1, n);
         return res;
     }
     public void backtrack(int index, int n) {
         if (index == n + 1) {
             res++;
             return;
         }
         for (int x : match[index]) {
             if (!vis[x]) {
                 vis[x] = true;
                 backtrack(index + 1, n);
                 vis[x] = false;
             }
         }
     }
    public int countArrangement0(int n) {
        // 动态规划+状态压缩，设f[mask]为mask对应的方案数，如f[111]，在最后一位填上的数字符合”优美排列“时，可由f[011]，f[101]，f[110]的状态转移而来。
        // 时间：O(n2^n)，空间：O(2^n)
        int[] f = new int[1 << n];
        f[0] = 1;
        for (int mask = 1; mask < (1 << n); mask++) {
            int num = Integer.bitCount(mask);
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0 && (num % (i + 1) == 0 || (i + 1) % num == 0)) {
                    f[mask] += f[mask ^ (1 << i)];
                }
            }
        }
        return f[(1 << n) - 1];
    }
}
