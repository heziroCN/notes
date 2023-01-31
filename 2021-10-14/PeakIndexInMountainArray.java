package haiwaitu.t20211014;

/**
 * @Author huangjunqiao
 * @Date 2021/10/15 01:24
 * @Description 剑指 Offer II 069. 山峰数组的顶部
 */
public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        // 二分查找，时间：O(logN)，空间：O(1)
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
