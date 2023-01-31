package haiwaitu.t20220502;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2022/05/03 18:26
 * @Description 1105. 填充书架
 */
public class MinHeightShelves {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        // dp，时间：O(n^2)，空间：O(n)
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1000 * 1000);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int maxHigh = 0;
            for (int j = i, w = 0; j >= 0 && w + books[j][0] <= shelfWidth;
                 w += books[j][0], j--) {
                maxHigh = Math.max(maxHigh, books[j][1]);
                dp[i + 1] = Math.min(dp[i + 1], dp[j] + maxHigh);
            }
        }
        return dp[n];
    }
}
