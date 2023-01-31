package haiwaitu.t20211027;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2021/10/28 21:05
 * @Description 46. 全排列
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        // 时间：O(n*n!)，空间：O(n)
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        for (int num : nums) {
            currList.add(num);
        }
        backtrack(0, currList, res);
        return res;
    }

    public void backtrack(int idx, List<Integer> currList, List<List<Integer>> res) {
        int size = currList.size();
        if (idx == size) {
            res.add(new ArrayList<>(currList));
            return;
        }
        for (int i = idx; i < size; i++) {
            Collections.swap(currList, i, idx);
            backtrack(idx + 1, currList, res);
            Collections.swap(currList, i, idx);
        }
    }
}
