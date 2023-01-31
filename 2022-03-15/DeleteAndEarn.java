package haiwaitu.t20220315;

/**
 * @Author huangjunqiao
 * @Date 2022/03/15 18:57
 * @Description 740. 删除并获得点数
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        // 时间：O(maxVal+n)，空间：O(maxVal)
        int n = nums.length, max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] sum = new int[max + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        int first = sum[0], second = Math.max(sum[0], sum[1]);
        for (int i = 2; i <= max; i++) {
            int temp = second;
            second = Math.max(second, first + sum[i]);
            first = temp;
        }
        return second;
    }
}
