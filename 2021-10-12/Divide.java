package haiwaitu.t20211012;

/**
 * @Author huangjunqiao
 * @Date 2021/10/12 20:17
 * @Description 29. 两数相除
 */
public class Divide {
    public int divide(int dividend, int divisor) {
        // 二分+快速乘
        // 0、受数值范围[−2^31,  2^31 − 1]限制，需要对边界条件特殊处理，防止溢出
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        if (dividend == 0) {
            return 0;
        }
        // 1、为了处理方便，将被除数和除数统一转换成正或负，由于负数−2^31转换成正数会溢出，所以选择转换成负数处理。
        int reverse = 1;
        if (dividend > 0) {
            dividend = -dividend;
            reverse = -reverse;
        }
        if (divisor > 0) {
            divisor = -divisor;
            reverse = -reverse;
        }
        // 2、被除数X和除数Y都为负数，X/Y=Z，则有ZY >= X > (Z+1)Y，可以通过二分查找，找到满足X > (Z+1)Y的最大的Z
        int l = 0, r = Integer.MAX_VALUE;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (quickAdd(dividend, divisor, mid + 1)) {
                // 满足 X>(Z+1)Y，需要继续减小或维持Z
                r = mid;
            } else {
                // 不满足 X>(Z+1)Y 了，需要增大Z，(Z+1)Y的结果随着Z增大而减小
                l = mid + 1;
            }
        }
        return reverse == 1 ? l : -l;
    }
    public boolean quickAdd(int x, int y, int z) {
        // 快速乘计算z*y的值，x，y是负数，z是正数
        int res = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {// z为奇数
                if (res < x - add) {// 判断x>yz，使用减法防止溢出
                    return true;
                }
                res += add;
            }
            if (z != 1) {
                if (add < x - add) {//判断x>yz
                    return true;
                }
                add += add;
            }
            z >>= 1;
        }
        return false;
    }
}
