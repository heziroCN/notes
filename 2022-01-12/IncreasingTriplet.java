package haiwaitu.t20220112;

/**
 * @Author huangjunqiao
 * @Date 2022/01/13 02:28
 * @Description 334. 递增的三元子序列
 */
public class IncreasingTriplet {
     public boolean increasingTriplet(int[] nums) {
         // 时间：O(n)，空间：O(n)
         int n = nums.length;
         int[] leftMin = new int[n], rightMax = new int[n];
         leftMin[0] = nums[0];
         rightMax[n - 1] = nums[n - 1];
         for (int i = 1; i < n; i++) {
             leftMin[i] = Math.min(nums[i], leftMin[i - 1]);
         }
         for (int i = n - 2; i >= 0; i--) {
             rightMax[i] = Math.max(nums[i], rightMax[i + 1]);
         }
         for (int i = 0; i < n; i++) {
             if (nums[i] > leftMin[i] && nums[i] < rightMax[i]) {
                 return true;
             }
         }
         return false;
     }

    public boolean increasingTriplet0(int[] nums) {
        // 贪心，时间：O(n)，空间：O(1)
        int n = nums.length;
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] > second) {
                return true;
            } else if (nums[i] > first) {
                second = nums[i];
            } else {
                first = nums[i];
            }
        }
        return false;
    }
}
