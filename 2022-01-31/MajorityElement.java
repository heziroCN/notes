package haiwaitu.t20220131;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2022/02/01 18:49
 * @Description 229. 求众数 II
 */
public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        // 时间：O(n)，空间：O(n)
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int bound = nums.length / 3;
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey(), cnt = entry.getValue();
            if (cnt > bound) {
                res.add(num);
            }
        }
        return res;
    }

    public List<Integer> majorityElement0(int[] nums){
        // 摩尔投票法， 时间：O(n)，空间：O(1)
        int num1 = 0, num2 = 0;
        int vote1 = 0, vote2 = 0;
        for (int num : nums) {
            if (num1 == num && vote1 > 0) {
                vote1++;
            } else if (num2 == num && vote2 > 0) {
                vote2++;
            } else if (vote1 == 0) {
                num1 = num;
                vote1++;
            } else if (vote2 == 0) {
                num2 = num;
                vote2++;
            } else {
                vote1--;
                vote2--;
            }
        }
        int cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (num1 == num) {
                cnt1++;
            } else if (num2 == num) {
                cnt2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (cnt1 > nums.length / 3) {
            res.add(num1);
        }
        if (cnt2 > nums.length / 3) {
            res.add(num2);
        }
        return res;
    }
}
