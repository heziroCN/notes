package haiwaitu.t20211219;

/**
 * @Author huangjunqiao
 * @Date 2021/12/19 12:35
 * @Description 5958. 股票平滑下跌阶段的数目
 */
public class GetDescentPeriods {
    public long getDescentPeriods(int[] prices) {
        // 时间：O(N)，空间：O(1)
        int len = prices.length;
        int smooth = 0;
        long res = len;
        for (int i = 1; i < len; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                smooth++;
                res += smooth;
            } else {
                smooth = 0;
            }
        }
        return res;
    }
}
