package haiwaitu.t20220328;

/**
 * @Author huangjunqiao
 * @Date 2022/03/28 16:07
 * @Description 268. 丢失的数字
 */
public class MissingNumber {
     public int missingNumber(int[] nums) {
         // 位运算，时间：O(n)，空间：O(1)，用时：9min
         int res = 0;
         int n = nums.length;
         for (int i = 0; i < n; i++) {
             res ^= nums[i];
         }
         for (int i = 0; i <= n; i++) {
             res ^= i;
         }
         return res;
     }

    public int missingNumber0(int[] nums) {
        // 数学，时间：O(n)，空间：O(1)
        int n = nums.length;
        int res = n * (n + 1) / 2;
        for (int num : nums) {
            res -= num;
        }
        return res;
    }
}
