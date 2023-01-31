package haiwaitu.t20210618;

/**
 * @Author huangjunqiao
 * @Date 2021/06/19 16:15
 * @Description 88. 合并两个有序数组
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 逆向双指针，时间O(m+n)，空间O(1)
        int idx1 = m - 1, idx2 = n - 1;
        int idx = m + n - 1;
        while (idx1 >= 0 && idx2 >= 0) {
            if (nums2[idx2] > nums1[idx1]) {
                nums1[idx--] = nums2[idx2--];
            } else {
                nums1[idx--] = nums1[idx1--];
            }
        }
        while (idx2 >= 0) {
            nums1[idx--] = nums2[idx2--];
        }
    }
}
