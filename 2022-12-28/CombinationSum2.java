package haiwaitu.t20221228;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2022/12/28 12:44
 * @Description 40. 组合总和 II
 */
public class CombinationSum2 {
    List<int[]> freq = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> seq = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 1、统计各候选数出现频率
        Arrays.sort(candidates);
        for (int num : candidates) {
            if (freq.isEmpty() || num != freq.get(freq.size() - 1)[0]) {
                freq.add(new int[] {num, 1});
            } else {
                freq.get(freq.size() - 1)[1]++;
            }
        }
        // 2、递归回溯，找出所有组合
        dfs(0, target);
        return res;
    }

    public void dfs(int pos, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(seq));
            return;
        }
        // 因为freq[0]有序，如果当前freq[pos]已经比target大，后面数自然更大，无需继续递归
        if (pos == freq.size() || target < freq.get(pos)[0]) {
            return;
        }
        // 3、计算最多使用多少个当前数，并从1开始逐个添加到组合里
        dfs(pos + 1, target);
        int most = Math.min(freq.get(pos)[1], target / freq.get(pos)[0]);
        for (int i = 1; i <= most; i++) {
            seq.add(freq.get(pos)[0]);
            dfs(pos + 1, target - i * freq.get(pos)[0]);
        }
        for (int i = 1; i <= most; i++) {
            seq.remove(seq.size() - 1);
        }
    }
}
