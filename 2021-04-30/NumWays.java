package haiwaitu.t20210430;

/**
 * @Author huangjunqiao
 * @Date 2021/04/30 15:04
 * @Description 剑指 Offer 10- II. 青蛙跳台阶问题
 */
public class NumWays {
     public int numWays(int n) {
         // dp递归，转移方程f(n)=f(n-1)+f(n-2)
         if (n <= 1) {
             return 1;
         }
         if (n == 2) {
             return 2;
         }
         return numWays(n - 1) + numWays(n - 2);
     }

//     public int numWays(int n) {
//         // 优化dp，数组缓存中间结果
//         if (n <= 1) {
//             return 1;
//         }
//         if (n == 2) {
//             return 2;
//         }
//         int[] dp = new int[n + 1];
//         dp[0] = 1;dp[1] = 1;dp[2] = 2;
//         for (int i = 3; i <= n; i++) {
//             dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000007;
//         }
//         return dp[n];
//     }

//    public int numWays(int n) {
//        // 滚动数组
//        if (n <= 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        int l = 1, m = 1, r = 2;
//        for (int i = 3; i <= n; i++) {
//            l = m;
//            m = r;
//            r = (l + m) % 1000000007;
//        }
//        return r;
//    }
}
