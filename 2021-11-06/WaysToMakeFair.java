package haiwaitu.t20211106;

/**
 * @Author huangjunqiao
 * @Date 2021/11/07 06:56
 * @Description 1664. 生成平衡数组的方案数
 */
public class WaysToMakeFair {
    public int waysToMakeFair(int[] nums) {
        int len = nums.length;
        int sumOdd = 0, sumEven = 0;
        for (int i = 0; i < len; i++) {
            if ((i & 1) == 1) {
                sumOdd += nums[i];
            } else {
                sumEven += nums[i];
            }
        }

        int cnt = 0;
        for (int i = len - 1; i >= 0; i--) {
            if ((i & 1) == 1) {
                sumOdd -= nums[i];
                if (sumOdd == sumEven) {
                    cnt++;
                }
                sumEven += nums[i];
            } else {
                sumEven -= nums[i];
                if (sumOdd == sumEven) {
                    cnt++;
                }
                sumOdd += nums[i];
            }
        }
        return cnt;
    }
}
