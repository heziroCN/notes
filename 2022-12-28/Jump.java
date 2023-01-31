package haiwaitu.t20221228;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2022/12/28 22:31
 * @Description 45. 跳跃游戏 II
 */
public class Jump {
    public int jump(int[] nums) {
        // dp，时间：O(n^2)，空间：O(n)
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    public int jump0(int[] nums) {
     // 贪心反向查找，时间：O(n^2)，空间：O(1)
     int n = nums.length;
     int pos = n - 1;
     int steps = 0;
     while (pos > 0) {
         for (int i = 0; i < pos; i++) {
             if (i + nums[i] >= pos) {
                 pos = i;
                 steps++;
                 break;
             }
         }
     }
     return steps;
    }

    public int jump1(int[] nums) {
        // 贪心正向查找，时间：O(n)，空间：O(1)
        int end = 0, maxPos = 0;
        int n = nums.length;
        int steps = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                // 到达边界，用当前步数能到达的最远位置更新边界
                end = maxPos;
                steps++;
            }
        }
        return steps;
    }
}
