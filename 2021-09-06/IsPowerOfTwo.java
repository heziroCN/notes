package haiwaitu.t20210906;

/**
 * @Author huangjunqiao
 * @Date 2021/09/06 14:01
 * @Description 231. 2 的幂
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        // 位运算解法1，n&(n-1)移除最低位的1，时间：O(1)，空间：O(1)
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo0(int n) {
        // 位运算解法2，正数的反码为按位取反然后+1，2的幂符合n&(-n)=n，时间：O(1)，空间：O(1)
        return n > 0 && (n & -n) == n;
    }
    
    public static final int BIT = 1 << 30;
    public boolean isPowerOfTwo1(int n) {
        // 判断n是否为最大的2次幂(2^30)的约数，时间：O(1)，空间：O(1)
        return n > 0 && (BIT % n) == 0;
    }

}
