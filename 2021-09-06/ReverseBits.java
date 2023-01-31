package haiwaitu.t20210906;

/**
 * @Author huangjunqiao
 * @Date 2021/09/06 13:04
 * @Description 190. 颠倒二进制位
 */
public class ReverseBits {
    public static final int M1 = 0x55555555;
    public static final int M2 = 0x33333333;
    public static final int M4 = 0x0f0f0f0f;
    public static final int M8 = 0x00ff00ff;
    public int reverseBits(int n) {
        // 位运算分治，时间：n的二进制位数为logn，即32，分治的次数根据二进制的位数取对数，即log(32)，用n表示即为O(log(logn))，空间：O(1)。
        n = n >>> 1 & M1 | (n & M1) << 1;// 奇偶位两两交换
        n = n >>> 2 & M2 | (n & M2) << 2;// 相邻两位一组，两两交换
        n = n >>> 4 & M4 | (n & M4) << 4;// 相邻四位一组，两两交换
        n = n >>> 8 & M8 | (n & M8) << 8;// 相邻八位一组，两两交换
        return n >>> 16 | n << 16;// 最后交换低十六位和高十六位
    }
}
