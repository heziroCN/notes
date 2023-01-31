package haiwaitu.t20210428;

import java.util.Random;

/**
 * @Author huangjunqiao
 * @Date 2021/04/28 21:58
 * @Description 215. 数组中的第K个最大元素
 */
public class FindKthLargest {
    private Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
        // 迭代解法
        int l = 0, r = nums.length - 1;
        while (true) {
            int pivot = partition(nums, l, r);
            if (pivot == k - 1) {
                return nums[pivot];
            } else if (pivot > k - 1) {
                r = pivot - 1;
            } else {
                l = pivot + 1;
            }
        }

    }
    public int partition(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }
        int pivot = start + rand.nextInt(end - start);
        swap(nums, pivot, end);
        int idx = start;
        for (int i = start; i < end; i++) {
            if (nums[i] > nums[end]) {
                swap(nums, i, idx);
                idx++;
            }
        }
        swap(nums, idx, end);
        return idx;
    }
    public void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }

    // public int findKthLargest(int[] nums, int k) {
    //     // 递归解法
    //     return quickSelect(nums, 0, nums.length - 1, k);
    // }
    public int quickSelect(int[] nums, int start, int end, int k) {
        int pivot = partition(nums, start, end);
        if (pivot == k - 1) {
            return nums[pivot];
        } else if (pivot > k - 1) {
            return quickSelect(nums, start, pivot - 1, k);
        } else {
            return quickSelect(nums, pivot + 1, end, k);
        }
    }

}
