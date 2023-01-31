package haiwaitu.t20210609;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/06/09 05:45
 * @Description 349. 两个数组的交集
 */
public class Intersection {
    // public int[] intersection(int[] nums1, int[] nums2) {
    //     // 排序+二分解法，时间O(N1logN2+N2logN2)，空间复杂度为排序使用的空间，O(logN1+logN2)
    //     Arrays.sort(nums2);
    //     Set<Integer> repeat = new HashSet<>();
    //     for (int num1 : nums1) {
    //         if (search(nums2, num1) != -1) {
    //             repeat.add(num1);
    //         }
    //     }
    //     int[] ans = new int[repeat.size()];
    //     int idx = 0;
    //     for (int rpNum : repeat) {
    //         ans[idx++] = rpNum;
    //     }
    //     return ans;
    // }
    // public int search(int[] nums, int target) {
    //     int l = 0, r = nums.length - 1;
    //     while (l <= r) {
    //         int mid =(l + r) >> 1;
    //         if (target == nums[mid]) {
    //             return mid;
    //         } else if (target > nums[mid]) {
    //             l = mid + 1;
    //         } else {
    //             r = mid - 1;
    //         }
    //     }
    //     return -1;
    // }

    // public int[] intersection(int[] nums1, int[] nums2) {
    //     // 哈希表解法，得益于set能在O(1)时间复杂度内判断是否有一个元素，retainAll的时间复杂度是O(N1)，总时间复杂度为O(N1+N2)，空间复杂度同样O(N1+N2)
    //     Set<Integer> set1 = new HashSet<>();
    //     Set<Integer> set2 = new HashSet<>();
    //     initTwoSet(set1, set2, nums1, nums2);
    //     set1.retainAll(set2);
    //     int[] result = new int[set1.size()];
    //     int idx = 0;
    //     for (int repeat : set1) {
    //         result[idx++] = repeat;
    //     }
    //     return result;
    // }
    // public void initTwoSet(Set<Integer> set1, Set<Integer> set2, int[] nums1, int[] nums2) {
    //     for (int num1 : nums1) {
    //         set1.add(num1);
    //     }
    //     for (int num2 : nums2) {
    //         set2.add(num2);
    //     }
    // }

    public int[] intersection(int[] nums1, int[] nums2) {
        // 排序+双指针，时间O(N1logN1+N2logN2)，空间复杂度为排序使用的空间，O(logN1+logN2)
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int idx = 0, idx1 = 0, idx2 = 0;
        int[] intersection = new int[len1 + len2];
        // 比较两数组元素，如果相等则加入结果集，否则小的数组指针向前移
        while (idx1 < len1 && idx2 < len2) {
            int num1 = nums1[idx1], num2 = nums2[idx2];
            if (num1 == num2) {
                if (idx == 0 || num1 != intersection[idx - 1]) {
                    intersection[idx++] = num1;
                }
                idx1++;
                idx2++;
            } else if (num1 < num2) {
                idx1++;
            } else {
                idx2++;
            }
        }
        int[] result = new int[idx];
        System.arraycopy(intersection, 0, result, 0, idx);
        return result;
    }

}
