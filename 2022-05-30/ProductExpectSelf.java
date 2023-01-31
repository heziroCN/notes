package haiwaitu.t20220530;

/**
 * @Author huangjunqiao
 * @Date 2022/05/30 17:53
 * @Description 238. 除自身以外数组的乘积
 */
public class ProductExpectSelf {
    public int[] productExceptSelf(int[] nums) {
        // 前缀乘积，时间：O(n)，空间：O(n)
        int n = nums.length;
        int[] left = new int[n], right = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
     public int[] productExceptSelf0(int[] nums) {
         // 前缀乘积+滚动数组，时间：O(n)，空间：O(1)
         int n = nums.length;
         int[] left = new int[n];
         left[0] = 1;
         for (int i = 1; i < n; i++) {
             left[i] = left[i - 1] * nums[i - 1];
         }
         int[] res = new int[n];
         int right = 1;
         for (int i = n - 1; i >= 0; i--) {
             res[i] = left[i] * right;
             right *= nums[i];
         }
         return res;
     }
}
