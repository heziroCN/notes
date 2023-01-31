package haiwaitu.t20210621;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangjunqiao
 * @Date 2021/06/22 12:30
 * @Description 560. 和为K的子数组
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        // 前缀和解法，用pre[]数组记录前x个数字和，则pre[i]-pre[k]为区间(k,i]，pre[i]-pre[k]=k即(k,i]子数组的和为k，实现上可以用一个变量代替pre数组，总时间O(N)，空间O(1)
        int cnt = 0, pre = 0;
        // 使用哈希表，以和为key，出现次数为value，实现以O(1)时间检测之前的子数组和是否为k。
        Map<Integer, Integer> map = new HashMap<>();
        // 需要以<0,1>初始化，和为0的情况有两种：1、数组内有正负数抵消的地方，以这些位置为开头位置的子数组；2、由于上述讨论(k,i]为左开右闭区间，因此另一种情况是以下标0为左边界的子数组。
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                cnt += map.get(pre - k);
            }
            map.put(pre, 1 + map.getOrDefault(pre, 0));
        }
        return cnt;
    }

    // public int subarraySum(int[] nums, int k) {
    //     // 暴力解法，O(N^2)，空间O(1)
    //     int cnt = 0;
    //     int len = nums.length;
    //     for (int i = 0; i < len; i++) {
    //         int sum = 0;
    //         for (int j = i; j < len; j++) {
    //             sum += nums[j];
    //             if (sum == k) {
    //                 cnt++;
    //             }
    //         }
    //     }
    //     return cnt;
    // }
}
