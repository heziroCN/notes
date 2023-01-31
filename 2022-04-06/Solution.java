package haiwaitu.t20220406;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2022/04/07 16:02
 * @Description 398. 随机数索引
 */
public class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Random rand = new Random();
    public Solution(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> ids = map.get(target);
        return ids.get(rand.nextInt(ids.size()));
    }
}
