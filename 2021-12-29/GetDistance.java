package haiwaitu.t20211229;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangjunqiao
 * @Date 2021/12/30 01:00
 * @Description 2121. 相同元素的间隔之和
 */
public class GetDistance {
    public long[] getDistances(int[] arr) {
        // 计算间隔和的数学表达式+哈希表，时间：O(n)，空间：O(n)
        Map<Integer, Integer> cnt = new HashMap<>();// 出现次数
        Map<Integer, Long> total = new HashMap<>();// 下标之和
        int len = arr.length;
        long[] res = new long[len];
        for (int i = 0; i < len; i++) {
            int val = arr[i];
            if (cnt.containsKey(val)) {
                res[i] += (long)i * cnt.get(val) - total.get(val);
            }
            cnt.put(val, cnt.getOrDefault(val, 0) + 1);
            total.put(val, total.getOrDefault(val, 0L) + i);
        }
        cnt.clear();
        total.clear();
        for (int i = len - 1; i >= 0; i--) {
            int val = arr[i];
            if (cnt.containsKey(val)) {
                res[i] += total.get(val) - (long)i * cnt.get(val);
            }
            cnt.put(val, cnt.getOrDefault(val, 0) + 1);
            total.put(val, total.getOrDefault(val, 0L) + i);
        }
        return res;
    }
}
