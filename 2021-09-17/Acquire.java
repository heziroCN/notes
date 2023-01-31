package haiwaitu.t20210917;

/**
 * @Author huangjunqiao
 * @Date 2021/09/17 20:44
 * @Description 位运算-获取
 */
public class Acquire {
    /**
     * 获取第k位
     *
     * @param num
     * @return
     */
    public int getKthBit(int num, int k) {
        return num & (1 << k);
    }

    /**
     * 获取最低有效位
     *
     * @param num
     * @return
     */
    public int getLowerestBit(int num) {
        // 1、n^(n-1)会将最低有效位左边的位全部置0，右边的位全部置1，并保留最低有效位
        // 2、由于右边全部位都是1，则1 + n^(n-1) 的结果相当于最低有效位左移
        // 3、在2的结果上右移即得到最低有效位
        return (1 + num ^ (num - 1)) >> 1;
    }

    /**
     * 获取最高有效位
     *
     * @param num
     * @return
     */
    public int getHighestBit(int num) {
        // 将最高位扩散到低位，然后+1，得到的结果相当于将最高位左移1位
        num |= (num >> 1);
        num |= (num >> 2);
        num |= (num >> 4);
        num |= (num >> 8);
        num |= (num >> 16);
        return (num + 1) >> 1;
    }
}
