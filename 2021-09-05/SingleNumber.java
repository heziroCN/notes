package haiwaitu.t20210905;

/**
 * @Author huangjunqiao
 * @Date 2021/09/05 08:40
 * @Description 136. 只出现一次的数字
 */
public class SingleNumber {
    // 类似题目：137. 只出现一次的数字 II
    public int singleNumber(int[] nums) {
        // 异或解法，时间：O(N)，空间：O(1)。
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
