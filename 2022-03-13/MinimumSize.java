package haiwaitu.t20220313;

/**
 * @Author huangjunqiao
 * @Date 2022/03/13 22:50
 * @Description 1760. 袋子里最少数目的球
 */
public class MinimumSize {
    public int minimumSize(int[] nums, int maxOperations) {
        // 二分：时间：O(nlogn)，空间：O(1)
        // y为一袋球数量，x为操作后单个袋子里球的数目最大值，则操作次数满足maxOperations>=(y - 1)/x，操作数与x成反比，因此可以通过二分查找，找到刚好满足的最小x
        int l = 1, r = 0;
        for (int num : nums) {
            r = Math.max(r, num);
        }
        while (l < r) {
            int x = (l + r) >> 1;
            long ops = 0;
            for (int y : nums) {
                ops += (y - 1) / x;
            }
            if (ops > maxOperations) {
                l = x + 1;
            } else {
                r = x;
            }
        }
        return l;
    }
}
