package haiwaitu.t20210426;

/**
 * @Author huangjunqiao
 * @Date 2021/04/26 14:48
 * @Description 300. 最长递增子序列
 */
public class LengthOfLIS {

    /**
     * dp[i]存储以nums[i]为结尾的最大升序子序列长度，可得状态转移方程
     * dp[i] = 1 + max(dp[j]),j < i且nums[j] < nums[i]
     * @param nums
     * @return
     */
     public int lengthOfLIS(int[] nums) {
         // dp，时间：O(n^2)，空间：O(n)
         int n = nums.length;
         int max = 0;
         int[] dp = new int[n];
         for (int i = 0; i < n; i++) {
             dp[i] = 1;
             for (int j = 0; j < i; j++) {
                 if (nums[i] > nums[j]) {
                     dp[i] = Math.max(dp[i], dp[j] + 1);
                 }
             }
             max = Math.max(max, dp[i]);
         }
         return max;
     }

    public int lengthOfLIS0(int[] nums) {
        // 二分+dp，时间：O(nlogn)，空间：O(n)
        int n = nums.length;
        int[] d = new int[n + 1];// dp[i]为长度为i的子序列中，末尾最小数字
        int len = 1;
        d[1] = nums[0];
        for (int i = 1; i < n; i++) {
            if (d[len] < nums[i]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len;
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (d[mid] < nums[i]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                if (d[1] > nums[i]) {
                    d[1] = nums[i];
                } else {
                    d[r] = nums[i];
                }
            }
        }
        return len;
    }

}
