package haiwaitu.t20220525;

/**
 * @Author huangjunqiao
 * @Date 2022/05/25 14:21
 * @Description 10. 正则表达式匹配
 */
public class IsMatch {
    public boolean isMatch(String s, String p) {
        // dp，时间：O(mn)，空间：O(mn)
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '*') {
                    if (match(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    // dp[i][j] = dp[i][j - 2] 0个字符
                    // dp[i][j] = s[i]==p[j-1] && dp[i-1][j] 1~n个字符
                    dp[i][j] = dp[i][j - 2];
                    if (match(s, p, i, j - 1)) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
    public boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
