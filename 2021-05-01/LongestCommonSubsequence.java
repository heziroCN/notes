package haiwaitu.t20210501;

/**
 * @Author huangjunqiao
 * @Date 2021/05/01 21:58
 * @Description 1143. 最长公共子序列
 */
public class LongestCommonSubsequence {
    /**
     * 动态规划，用二维数组dp[i][j] 表示长为i的text1，长为2的text2的最长公共子序列长度。
     * 若text1第i位字符和text2第j位字符一样，则可以通过dp[i-1][j-1]+1得到dp[i][j]的值；
     * 若不想等，则考虑长度最接近的两个字符串，选择dp[i-1][j]或者dp[i][j-1]，状态转移方程：
     * dp[i][j]= dp[i-1][j-1]+1            , c1 = c2
     *           max(dp[i][j-1],dp[i-1][j]), c1 != c2
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        char c1;
        for (int i = 1; i <= len1; i++) {
            c1 = text1.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                if (c1 == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
