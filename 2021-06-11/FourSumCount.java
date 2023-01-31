package haiwaitu.t20210611;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangjunqiao
 * @Date 2021/06/12 07:52
 * @Description 454. 四数相加 II
 */
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 哈希表解法，时间O(N^2)，空间O(N)
        Map<Integer, Integer> map = new HashMap<>();
        for (int u : nums1) {
            for (int v : nums2) {
                map.put(u + v, 1 + map.getOrDefault(u + v, 0));
            }
        }
        int ans = 0;
        for (int u : nums3) {
            for (int v : nums4) {
                if (map.containsKey(-u - v)) {
                    ans += map.get(-u - v);
                }
            }
        }
        return ans;
    }
}
