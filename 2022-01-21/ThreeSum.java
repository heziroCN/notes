package haiwaitu.t20220121;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2022/01/21 14:44
 * @Description 15. 三数之和
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // 时间：O(n^2)，空间：O(logn)
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int l = i + 1, r = len - 1;
            while (l < r) {
                if (l > i + 1 && nums[l - 1] == nums[l]) {
                    l++;
                    continue;
                }
                if (r < len - 1 && nums[r + 1] == nums[r]) {
                    r--;
                    continue;
                }
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> list = buildList(nums[i], nums[l], nums[r]);
                    res.add(list);
                    l++;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
    public List<Integer> buildList(int num1, int num2, int num3) {
        List<Integer> list = new ArrayList<>();
        list.add(num1);
        list.add(num2);
        list.add(num3);
        return list;
    }
}
