package haiwaitu.t20220803;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author huangjunqiao
 * @Date 2022/08/03 18:58
 * @Description 140. 单词拆分 II
 */
public class WordBreak {
    Set<String> set = new HashSet<>();
    List<List<String>> strs = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        // 回溯，时间：O(n*2^n)，空间：O(n*2^n)
        set = new HashSet<>(wordDict);
        backtrack(s, 0, 0, new ArrayList<>());
        List<String> res = new ArrayList<>();
        for (List<String> str : strs) {
            res.add(String.join(" ", str));
        }
        return res;
    }
    public void backtrack(String s, int idx, int lastSpace, List<String> slices) {
        int n = s.length();
        if (idx == n) {
            if (lastSpace == n) {
                strs.add(slices);
            }
            return;
        }
        String curr = s.substring(lastSpace, idx + 1);
        if (set.contains(curr)) {
            List<String> newSlices = new ArrayList<>(slices);
            newSlices.add(curr);
            backtrack(s, idx + 1, idx + 1, newSlices);
        }
        backtrack(s, idx + 1, lastSpace, slices);
    }
}
