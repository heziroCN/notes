package haiwaitu.t20210915;

/**
 * @Author huangjunqiao
 * @Date 2021/09/15 15:58
 * @Description 位运算-设置值
 */
public class SetValue {
    /**
     * 将第k位设置为1
     *
     * @param num
     * @param k
     * @return
     */
    public int setK1(int num, int k) {
        return num | 1 << k;
    }

    /**
     * 将第k位设置为0
     *
     * @param num
     * @param k
     * @return
     */
    public int setK0(int num, int k) {

        return num & ~(1 << k);
    }

    /**
     * 将第k位取反
     *
     * @param num
     * @param k
     * @return
     */
    public int reverseKth(int num, int k) {
        return num ^ 1 << k;
    }

}
