package haiwaitu.t20220609;

/**
 * @Author huangjunqiao
 * @Date 2022/06/11 04:06
 * @Description 44. 通配符匹配
 */
public class IsMatch {
    public boolean isMatch(String s, String p) {
        // 时间：O(mn)，空间：O(mn)
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '*') {
                    if (i > 0) {
                        dp[i][j] = dp[i - 1][j - 1] && match(s, p, i, j);
                    }
                } else {
                    dp[i][j] = dp[i][j - 1];// 不使用*
                    if (i > 0) {
                        dp[i][j] |= dp[i - 1][j];// 使用*（匹配s的1到多个字符）
                    }
                }
            }
        }
        return dp[m][n];
    }
    public boolean match(String s, String p, int i, int j) {
        if (p.charAt(j - 1) == '?') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
