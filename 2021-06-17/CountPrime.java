package haiwaitu.t20210617;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2021/06/18 11:52
 * @Description 204. 计数质数
 */
public class CountPrime {
     public int countPrimes(int n) {
         // 暴力枚举，时间O(N^(2/3))，空间O(1)
         int cnt = 0;
         for (int i = 2; i < n; i++) {
             if (isPrime(i)) {
                 cnt++;
             }
         }
         return cnt;
     }
     boolean isPrime(int n) {
         // 如果n是合数，那么必然存在两个因数a,b，两个因数中小的那个，必然<=n的开方，因此枚举范围可以从[2,n-1]缩小到[2,n的开方]
         for (int i = 2; i * i <= n; i++) {
             if (n % i == 0) {
                 return false;
             }
         }
         return true;
     }

    public int countPrimes0(int n) {
        // 埃氏筛，基于：如果x是质数，那么x倍数2x，3x...一定不是质数。时间O(nloglogn)，空间O(n)
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                cnt++;
                // 从2x开始标记是冗余的，2x被2的所有倍数标记过了，3x被3的所有倍数标记过了...以此类推，(x-1)x被x-1的所有倍数标记过了，所以从x^2开始标记即可。
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return cnt;
    }
}
