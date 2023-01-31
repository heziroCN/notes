package haiwaitu.t20211226;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2021/12/27 16:01
 * @Description 825. 适龄的朋友
 */
public class NumFriendRequests {
     public int numFriendRequests(int[] ages) {
         // 排序+双指针，时间：O(nlogn)，空间：O(logn)
         int n = ages.length;
         int res = 0;
         Arrays.sort(ages);
         int l = 0, r = 0;
         for (int age : ages) {
             if (age < 15) {
                 continue;
             }
             while (ages[l] <= age / 2 + 7) {
                 l++;
             }
             while (r + 1 < n && ages[r + 1] <= age) {
                 r++;
             }
             res += r - l;
         }
         return res;
     }

    public int numFriendRequests0(int[] ages) {
        // 计数排序+前缀和，时间：O(N+C)，空间：O(C)。C为年龄范围
        int[] cnt = new int[121];
        for (int age : ages) {
            cnt[age]++;
        }
        int[] prefix = new int[121];
        for (int i = 1; i < 121; i++) {
            prefix[i] = prefix[i - 1] + cnt[i];
        }
        int res = 0;
        for (int i = 15; i < 121; i++) {
            if (cnt[i] > 0) {
                res += cnt[i] * (prefix[i] - prefix[i / 2 + 7] - 1);
            }
        }
        return res;
    }
}
