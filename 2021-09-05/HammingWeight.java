package haiwaitu.t20210905;

/**
 * @Author huangjunqiao
 * @Date 2021/09/05 08:43
 * @Description 191. 位1的个数
 */
public class HammingWeight {
    /**
     * 对一个二进制数减一，有两种情况：1、如果最低位是1，那么最低位变成0，其他位保持不变。
     * 2、如果最低位是0，那么从右往左数第一个1变成0，右边的0变成1。
     * 可以得到一个规律：对任意数减一，会将最低位的1变成0。
     * 对数字进行减一后原数按位与，可以将原数最低位的1变成0，同时保留高位。
     * 类似题目：338. 比特位计数
     */
    public int hammingWeight(int n) {
        // 按位与，时间：循环次数为1的个数，最坏情况下全是1，即O(logN)，空间：O(1)
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }
}
