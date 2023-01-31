package haiwaitu.t20210428;

/**
 * @Author huangjunqiao
 * @Date 2021/04/28 19:25
 * @Description 70. 爬楼梯
 */
public class ClimbStairs {
    /**
     * 动态规划，到n阶可以从n-1阶爬1阶，或者从n-2阶爬2阶，
     * 到n-1阶可以从n-2阶爬1阶，或者从n-3阶爬2阶...
     * 记f(n)为到n阶楼梯的方法数，可以写出转移方程：
     * f(n)=f(n-1) + f(n-2)，但直接使用递归的话，会导致中间结果重复计算，
     * 可以用数组缓存中间结果，进一步优化，数组可以改为"滚动数组"，用3个变量代替
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        // "滚动数组"，l存储f(n-2),m存储f(n-1),r存储f(n)
        int l = 0, m = 1,r = 2;
        for (int i = 3; i <= n; i++) {
            l = m;
            m = r;
            r = l + m;
        }
        return r;
    }
}
