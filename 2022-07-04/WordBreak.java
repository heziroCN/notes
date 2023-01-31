package haiwaitu.t20220704;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2022/07/04 16:21
 * @Description 139. 单词拆分
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 时间：O(n^2)，空间：O(n)
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
