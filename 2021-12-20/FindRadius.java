package haiwaitu.t20211220;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2021/12/20 16:52
 * @Description 475. 供暖器
 */
public class FindRadius {
    public int findRadius(int[] houses, int[] heaters) {
        // 排序二分，只对heaters排序，时间：O(NlogN+MlogN)，空间：O(logN)
        Arrays.sort(heaters);
        int res = 0;
        for (int house : houses) {
            int i = binarySearch(heaters, house);
            int j = (i == heaters.length - 1) ? i : i + 1 ;
            int lDist = Math.abs(heaters[i] - house);
            int rDist = Math.abs(heaters[j] - house);
            int curDist = Math.min(lDist, rDist);
            res = Math.max(res, curDist);
        }
        return res;
    }
    public int binarySearch(int[] heaters, int tar) {
        int l = 0, r = heaters.length - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (tar >= heaters[mid]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public int findRadius0(int[] houses, int[] heaters) {
        // 排序双指针，时间：O(MlogM+NlogN)，空间：O(logM+logN)
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        int idx = 0, len = heaters.length;
        for (int house : houses) {
            while (idx < len - 1 && Math.abs(heaters[idx + 1] - house) <= Math.abs(heaters[idx] - house)) {
                idx++;
            }
            int curDist = Math.abs(heaters[idx] - house);
            res = Math.max(res, curDist);
        }
        return res;
    }
}
