package haiwaitu.t20210512;

/**
 * @Author huangjunqiao
 * @Date 2021/05/12 15:33
 * @Description 852. 山脉数组的峰顶索引
 */
public class PeakIndexInMountainArray {
     public int peakIndexInMountainArray(int[] arr) {
         // 直接遍历 时间 O(N)
         for (int i = 1; i < arr.length; i++) {
             if (arr[i] < arr[i - 1]) {
                 return i - 1;
             }
         }
         return -1;
     }
    public int peakIndexInMountainArray0(int[] arr) {
        // 二分查找 O(logN) 目标位置山顶位于递增区间最后一位，递减区间的第一位。
        // 每次比较区间中点arr[mid]和arr[mid+1]，如果arr[mid]<arr[mid+1]，说明两者处于递增区间，
        // 山顶只可能在mid之后，下次搜索[mid+1,r]；
        // 反之若arr[mid]>arr[mid+1]，说明两者处于递减区间，山顶只可能在mid+1之前，同样为了不错过山顶，下次搜索[l,mid]
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while (l < r) {
            mid = (l + r) >> 1;
            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
