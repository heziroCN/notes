package haiwaitu.t20211027;

/**
 * @Author huangjunqiao
 * @Date 2021/10/28 16:11
 * @Description 4. 寻找两个正序数组的中位数
 */
public class FindMediumSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 归并排序再取中间元素，时间：O(m+n)，空间：O(m+n)
        int len1 = nums1.length, len2 = nums2.length;
        int idx1 = 0, idx2 = 0;
        int idx = 0;
        int[] nums = new int[len1 + len2];
        while (idx1 < len1 && idx2 < len2) {
            if (nums1[idx1] < nums2[idx2]) {
                nums[idx++] = nums1[idx1++];
            } else {
                nums[idx++] = nums2[idx2++];
            }
        }
        while (idx1 < len1) {
            nums[idx++] = nums1[idx1++];
        }
        while (idx2 < len2) {
            nums[idx++] = nums2[idx2++];
        }

        return findMiddle(nums);
    }
    public double findMiddle(int[] nums) {
        int len = nums.length;
        if (len % 2 != 0) {
            return nums[len / 2];
        } else {
            double l = nums[(len - 1) / 2];
            double r = nums[len / 2];
            return (l + r) / 2;
        }
    }

    public double findMedianSortedArrays0(int[] nums1, int[] nums2) {
        // 二分搜索，时间：O(log(m+n))，空间：O(1)
        int len1 = nums1.length, len2 = nums2.length;
        int len = len1 + len2;
        if (len % 2 == 1) {
            return getKthElement(nums1, nums2, len / 2 + 1);
        } else {
            double leftMid = getKthElement(nums1, nums2, len / 2);
            double rightMid = getKthElement(nums1, nums2, len / 2 + 1);
            return (leftMid + rightMid) / 2;
        }
    }
    public double getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int idx1 = 0, idx2 = 0;
        while (true) {
            if (idx1 == len1) {
                return nums2[idx2 + k - 1];
            }
            if (idx2 == len2) {
                return nums1[idx1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[idx1], nums2[idx2]);
            }
            int half = k / 2;
            int mid1 = Math.min(idx1 + half, len1) - 1;
            int mid2 = Math.min(idx2 + half, len2) - 1;
            if (nums1[mid1] < nums2[mid2]) {// 淘汰nums1[mid1]左边的元素
                k -= (mid1 - idx1 + 1);
                idx1 = mid1 + 1;
            } else {
                k -= (mid2 - idx2 + 1);
                idx2 = mid2 + 1;
            }
        }
    }
}
