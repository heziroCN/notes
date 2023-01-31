package haiwaitu.t20220120;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author huangjunqiao
 * @Date 2022/01/20 15:48
 * @Description 219. 存在重复元素 II
 */
public class ContainsNearbyDuplicate {
     public boolean containsNearbyDuplicate(int[] nums, int k) {
         // 哈希表<num,index>，时间：O(n)，空间：O(n)
         Map<Integer, Integer> map = new HashMap<>();
         int n = nums.length;
         for (int i = 0; i < n; i++) {
             int num = nums[i];
             if (map.containsKey(num) && i - map.get(num) <= k) {
                 return true;
             }
             map.put(num, i);
         }
         return false;
     }
    public boolean containsNearbyDuplicate0(int[] nums, int k) {
        // 哈希集合，时间：O(n)，空间：O(k)
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
