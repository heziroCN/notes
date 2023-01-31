package haiwaitu.t20211111;

/**
 * @Author huangjunqiao
 * @Date 2021/11/11 16:15
 * @Description 123. 买卖股票的最佳时机 III
 */
public class MaxProfits {
    public int maxProfit(int[] prices) {
        // 时间：O(N)，空间：O(N)
        int len = prices.length;
        int buy1 = -prices[0], sell1 = 0, buy2 = -prices[0], sell2 = 0;//分别表示两次买卖期间的4个状态
        for (int i = 1; i < len; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, prices[i] + buy1);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
