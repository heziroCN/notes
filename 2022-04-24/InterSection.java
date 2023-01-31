package haiwaitu.t20220424;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2022/04/24 22:09
 * @Description 6041. 多个数组求交集
 */
public class InterSection {
    public List<Integer> intersection(int[][] nums) {
        // 时间：O(mn)，空间：O(n)
        int[] cnt = new int[1001];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int num : nums[i]) {
                cnt[num]++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= 1000; i++) {
            if (cnt[i] == n) {
                res.add(i);
            }
        }
        return res;
    }
}
