package haiwaitu.t20211011;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangjunqiao
 * @Date 2021/10/11 00:31
 * @Description 982. 按位与为零的三元组
 */
public class CountTriplets {
    public int countTriplets(int[] nums) {
        // 哈希表解法，由于数据范围在 2^16 内，哈希表至多有2^16个kv对，时间：O(N*2^16)，空间：O(2^16)
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        // 记录两两按位与结果的频率
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int num = nums[i] & nums[j];
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int cnt = entry.getValue();
            if (num == 0) {
                res += cnt * len;
                continue;
            }
            for (int i = 0; i < len; i++) {
                if ((nums[i] & num) == 0) {
                    res += cnt;
                }
            }
        }
        return res;
    }
}
