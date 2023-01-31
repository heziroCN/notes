package haiwaitu.t20220120;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @Author huangjunqiao
 * @Date 2022/01/24 00:05
 * @Description 220. 存在重复元素 III
 */
public class ContainsNearbyAlmostDuplicate {
     public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
         // 滑动窗口+红黑树，时间：O(nlog(min(n,k)))，空间：O(min(n,k))
         int n = nums.length;
         TreeSet<Long> set = new TreeSet<>();
         for (int i = 0; i < n; i++) {
             Long ln = set.ceiling((long) nums[i] - (long) t);
             if (ln != null && ln <= (long) nums[i] + (long) t) {
                 return true;
             }
             set.add((long) nums[i]);
             if (i >= k) {
                 set.remove((long) nums[i - k]);
             }
         }
         return false;
     }

    public boolean containsNearbyAlmostDuplicate0(int[] nums, int k, int t) {
        // 滑动窗口+桶，时间：O(n)，空间：O(min(n,k))
        int n = nums.length;
        long w = t + 1;
        Map<Long, Long> buckets = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long id = getId(nums[i], w);
            if (buckets.containsKey(id)) {
                return true;
            }
            if (buckets.containsKey(id - 1) && Math.abs((long) nums[i] - buckets.get(id - 1)) < w) {
                return true;
            }
            if (buckets.containsKey(id + 1) && Math.abs((long) nums[i] - buckets.get(id + 1)) < w) {
                return true;
            }
            buckets.put(id, (long) nums[i]);
            if (i >= k) {
                buckets.remove(getId((long) nums[i - k], w));
            }
        }
        return false;
    }
    public long getId(long num, long w) {
        if (num >= 0) {
            return num / w;
        }
        return (num + 1) / w - 1;
    }
}
