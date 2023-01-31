package haiwaitu.t20211104;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangjunqiao
 * @Date 2021/11/05 18:09
 * @Description 1218. 最长定差子序列
 */
public class LongestSubsequence {
    public int longestSubsequence(int[] arr, int difference) {
        // 动态规划，时间：O(N)，空间：O(N)
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : arr) {
            map.put(num, map.getOrDefault(num - difference, 0) + 1);
            res = Math.max(res, map.get(num));
        }
        return res;
    }
}
