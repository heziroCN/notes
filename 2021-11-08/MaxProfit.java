package haiwaitu.t20211108;

/**
 * @Author huangjunqiao
 * @Date 2021/11/09 10:06
 * @Description 121. 买卖股票的最佳时机
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        // 时间：O(N)，空间：O(1)
        int currMin = Integer.MAX_VALUE;
        int res = 0;
        for (int price : prices) {
            currMin = Math.min(currMin, price);
            res = Math.max(res, price - currMin);
        }
        return res;
    }
}
