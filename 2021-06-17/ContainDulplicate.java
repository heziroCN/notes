package haiwaitu.t20210617;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author huangjunqiao
 * @Date 2021/06/18 11:58
 * @Description 217. 存在重复元素
 */
public class ContainDulplicate {
    public boolean containsDuplicate(int[] nums) {
        // 借助哈希表，时间O(N)，空间O(N)
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate0(int[] nums) {
        // 排序解法，时间O(NlogN)，空间O(logN)
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
