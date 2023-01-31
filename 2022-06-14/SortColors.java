package haiwaitu.t20220614;

/**
 * @Author huangjunqiao
 * @Date 2022/06/15 02:02
 * @Description 75. 颜色分类
 */
public class SortColors {
     public void sortColors(int[] nums) {
         // 单指针两次遍历，时间：O(n)，空间：O(1)
         int n = nums.length;
         int p = 0;
         for (int i = 0; i < n; i++) {
             if (nums[i] == 0) {
                 swap(nums, i, p);
                 p++;
             }
         }
         for (int i = 0; i < n; i++) {
             if (nums[i] == 1) {
                 swap(nums, i, p);
                 p++;
             }
         }
     }
    public void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
     public void sortColors0(int[] nums) {
         // 双指针0-1，时间：O(n)，空间：O(1)
         int n = nums.length;
         int p0 = 0, p1 = 0;
         for (int i = 0; i < n; i++) {
             if (nums[i] == 1) {
                 swap(nums, i, p1);
                 p1++;
             } else if (nums[i] == 0) {
                 swap(nums, i, p0);
                 if (p0 < p1) {
                     swap(nums, i, p1);
                 }
                 p0++;
                 p1++;
             }
         }
     }
    public void sortColors1(int[] nums) {
        // 双指针0-2，时间：O(n)，空间：O(1)
        int n = nums.length;
        int p0 = 0, p2 = n - 1, i = 0;
        while (i <= p2) {
            while (i <= p2 && nums[i] == 2) {
                swap(nums, i, p2);
                p2--;
            }
            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
            }
            i++;
        }
    }
}
