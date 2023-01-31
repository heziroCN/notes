package haiwaitu.t20220705;

/**
 * @Author huangjunqiao
 * @Date 2022/07/05 17:07
 * @Description 31. 下一个排列
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // 时间：O(n)，空间：O(1)
        int n = nums.length, idx = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }
        // 从后往前找的第一个升序对为(i, i+1)，因此区间[i+1, n-1]必然单调递减
        if (idx != -1) {
            for (int i = n - 1; i > idx; i--) {// 找出仅仅大于nums[idx]的元素下标
                if (nums[i] > nums[idx]) {
                    swap(nums, idx, i);
                    break;
                }
            }
        }
        reverse(nums, idx + 1, n - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    public void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}
