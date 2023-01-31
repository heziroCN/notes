package haiwaitu.t20220121;

import java.util.Random;

/**
 * @Author huangjunqiao
 * @Date 2022/01/20 16:05
 * @Description 912. 排序数组
 */
public class SortArray {
     Random rand = new Random();
     public int[] sortArray0(int[] nums) {
         // 快排，时间：O(nlogn)，空间：O(logn)
         quickSort(nums, 0, nums.length - 1);
         return nums;
     }
     public void quickSort(int[] nums, int start, int end) {
         if (start >= end) {
             return;
         }
         int pivot = partition(nums, start, end);
         quickSort(nums, start, pivot - 1);
         quickSort(nums, pivot + 1, end);
     }
     public int partition(int[] nums, int start, int end) {
         int pivot = start + rand.nextInt(end - start);
         swap(nums, pivot, end);
         int idx = start;
         for (int i = start; i < end; i++) {
             if (nums[i] < nums[end]) {
                 swap(nums, idx, i);
                 idx++;
             }
         }
         swap(nums, idx, end);
         return idx;
     }
     public void swap(int[] nums, int l, int r) {
         int temp = nums[l];
         nums[l] = nums[r];
         nums[r] = temp;
     }

     public int[] sortArray1(int[] nums) {
         // 归并排序，时间：O(nlogn)，空间：O(logn)
         return mergeSort(nums, 0, nums.length - 1);
     }
     public int[] mergeSort(int[] nums, int start, int end) {
         if (start >= end) {
             return new int[]{nums[start]};
         }
         int mid = (start + end) / 2;
         int[] left = mergeSort(nums, start, mid);
         int[] right = mergeSort(nums, mid + 1, end);
         return merge(left, right);
     }
     public int[] merge(int[] nums1, int[] nums2) {
         int len1 = nums1.length, len2 = nums2.length;
         int[] res = new int[len1 + len2];
         int idx1 = 0, idx2 = 0, idx = 0;
         while (idx1 < len1 || idx2 < len2) {
             if (idx1 == len1) {
                 res[idx1 + idx2] = nums2[idx2];
                 idx2++;
                 continue;
             } else if (idx2 == len2) {
                 res[idx1 + idx2] = nums1[idx1];
                 idx1++;
                 continue;
             }
             if (nums1[idx1] < nums2[idx2]) {
                 res[idx1 + idx2] = nums1[idx1];
                 idx1++;
             } else {
                 res[idx1 + idx2] = nums2[idx2];
                 idx2++;
             }
         }
         return res;
     }
    public int[] sortArray2(int[] nums) {
        // 插入排序，时间：O(n^2)，空间：O(1)
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
        return nums;
    }
}
