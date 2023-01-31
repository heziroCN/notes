package haiwaitu.t20211111;

/**
 * @Author huangjunqiao
 * @Date 2021/11/11 16:16
 * @Description 392. 判断子序列
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        // 时间：O(m+n)，空间：O(1)，m、n为s、t长度
        int sLen = s.length(), tLen = t.length();
        int i = 0, j = 0;
        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == sLen;
    }

    public boolean isSubsequence0(String s, String t) {
        // 时间：O(mS+n)，空间：O(mS)，S为字符集大小
        int sLen = s.length(), tLen = t.length();
        int[][] dp = new int[tLen + 1][26];// dp[i][j]表示从位置i往后第一次出现字符j的位置
        for (int i = 0; i < 26; i++) {
            dp[tLen][i] = tLen;
        }
        for (int i = tLen - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) - 'a' == j) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        int tIdx = 0;
        for (int i = 0; i < sLen; i++) {
            if (dp[tIdx][s.charAt(i) - 'a'] == tLen) {
                return false;
            }
            tIdx = dp[tIdx][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}
