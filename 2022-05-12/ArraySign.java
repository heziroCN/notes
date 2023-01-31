package haiwaitu.t20220512;

/**
 * @Author huangjunqiao
 * @Date 2022/05/12 13:51
 * @Description 1822. 数组元素积的符号
 */
public class ArraySign {
    public int arraySign(int[] nums) {
        // 时间：O(n)，空间：O(1)
        int negative = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                negative++;
            }
        }
        return negative % 2 == 0 ? 1 : -1;

    }
}
