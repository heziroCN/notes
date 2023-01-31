package haiwaitu.t20210614;

/**
 * @Author huangjunqiao
 * @Date 2021/06/15 09:29
 * @Description 50. Pow(x, n)
 */
public class MyPow {
    public double myPow(double x, int n) {
        // 快速幂等法-递归，时间O(log(n))，空间O(log(n))
        long ln = n;
        return n >= 0 ? powCore(x, ln) : 1 / powCore(x, -ln);
    }
    public double powCore(double x, long ln) {
        if (ln == 0) {
            return 1;
        }
        double sub = powCore(x, ln / 2);
        return ln % 2 == 0 ? sub * sub : sub * sub * x;
    }

    public double myPow0(double x, int n) {
        // 快速幂等法-迭代，时间O(log(n))，空间O(1)
        long ln = n;
        return n >= 0 ? quickPow(x, ln) : 1 / quickPow(x, -ln);
    }
    public double quickPow(double x, long ln) {
        double ans = 1;
        while (ln != 0) {
            if ((ln & 1) != 0) {
                ans *= x;
            }
            x *= x;
            ln >>= 1;
        }
        return ans;
    }
}
