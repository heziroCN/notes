package haiwaitu.t20211012;

/**
 * @Author huangjunqiao
 * @Date 2021/10/12 18:17
 * @Description 279. 完全平方数
 */
public class NumSquares {
    public int numSquares(int n) {
        // 动态规划，时间：O(n√n)，空间：O(n)
        // f[n]表示组成n的完全平方数个数，如果有i+(j^2)=n，则f[n]=f[i]+1
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int closest = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                closest = Math.min(closest, f[i - j * j]);
            }
            f[i] = closest + 1;
        }
        return f[n];
    }
}
