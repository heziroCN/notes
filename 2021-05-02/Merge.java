package haiwaitu.t20210502;

/**
 * @Author huangjunqiao
 * @Date 2021/05/02 21:14
 * @Description 88. 合并两个有序数组
 */
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 逆向双指针合并，从后往前放置元素，这样不需要移动其他元素，时间O(m+n)，空间O(1)
        int idx = m + n - 1;
        m--;
        n--;
        // 当nums1和nums2数组都还有元素时，从数组末尾比较大小并放置大的元素
        while (m >= 0 && n >= 0) {
            if (nums1[m] < nums2[n]) {
                nums1[idx--] = nums2[n--];
            } else {
                nums1[idx--] = nums1[m--];
            }
        }
        // 因为nums1就是合并后的数组，所以只需要处理nums2剩余的元素就可以了
        while (n >= 0) {
            nums1[idx--] = nums2[n--];
        }
    }
}
