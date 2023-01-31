package haiwaitu.t20220309;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2022/03/09 17:46
 * @Description 962. 最大宽度坡
 */
public class MaxWidthRamp {
    public int maxWidthRamp(int[] nums) {
        // 对下标按值排序，时间：O(nlogn)，空间：O(n)
        int n = nums.length;
        Integer[] idxs = new Integer[n];
        for (int i = 0; i < n; i++) {
            idxs[i] = i;
        }
        Arrays.sort(idxs, (a, b) -> (nums[a] - nums[b]));
        int min = idxs[0];
        int res = 0;
        for (int idx : idxs) {
            res = Math.max(res, idx - min);
            min = Math.min(min, idx);
        }
        return res;
    }

    public int maxWidthRamp0(int[] nums) {
        // 二分检索单调列表，时间：O(nlogn)，空间：O(n)
        int n = nums.length;
        List<int[]> candidates = new ArrayList<>();
        candidates.add(new int[] {nums[n - 1], n - 1});
        int res = 0;
        for (int i = n - 2; i >= 0; i--) {
            // 二分
            int lo = 0, hi = candidates.size();
            while (lo < hi) {
                int mid = (lo + hi) >> 1;
                if (candidates.get(mid)[0] >= nums[i]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            if (lo >= candidates.size()) {
                candidates.add(new int[] {nums[i], i});
            } else {
                int j = candidates.get(lo)[1];
                res = Math.max(res, j - i);
            }
        }
        return res;
    }
}
