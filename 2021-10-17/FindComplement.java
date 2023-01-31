package haiwaitu.t20211017;

/**
 * @Author huangjunqiao
 * @Date 2021/10/18 22:39
 * @Description 476. 数字的补数
 */
public class FindComplement {
    public int findComplement(int num) {
        // 时间：O(lognum)，空间：O(1)
        int bit = num;
        int mask = 0;
        while (bit > 0) {
            mask |= bit;
            bit >>= 1;
        }
        return num ^ mask;
    }

    public int findComplement0(int num) {
        // 时间：O(loglognum)，空间：O(1)
        int mask = num;
        mask |= (mask >> 1);
        mask |= (mask >> 2);
        mask |= (mask >> 4);
        mask |= (mask >> 8);
        mask |= (mask >> 16);
        return mask ^ num;
    }
}
