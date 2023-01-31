package haiwaitu.t20211020;

/**
 * @Author huangjunqiao
 * @Date 2021/10/20 13:50
 * @Description 453. 最小操作次数使数组元素相等
 */
public class MinMoves {
    public int minMoves(int[] nums) {
        // n-1个元素+1直到所有元素相等，需要的操作次数。等价于将最大元素-1直到所有元素相等需要的操作次数。可以累加所有元素和最小元素的差值得到。时间：O(N)，空间：O(1)
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int cnt = 0;
        for (int num : nums) {
            cnt += (num - min);
        }
        return cnt;
    }
}
