package haiwaitu.t20211029;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2021/10/30 16:43
 * @Description 47. 全排列 II
 */
public class PermuteUnique {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 回溯+去重
        int len = nums.length;
        boolean[] visited = new boolean[len];
        List<Integer> currList = new ArrayList<>();

        Arrays.sort(nums);// 排序方便处理重复排列
        backtrack(0, nums, currList, visited);
        return res;
    }
    public void backtrack(int idx, int[] nums, List<Integer> currList, boolean[] visited) {
        int len = nums.length;
        if (idx == len) {
            res.add(new ArrayList<>(currList));
            return;
        }
        // 去重规则：填第idx个数时，如果nums[i]重复，则只有在“前面的重复数都选择了”这一情况才会继续递归，而这种情况在全排列里只有一种，由此实现去重。
        for (int i = 0; i < len; i++) {
            if (visited[i] || (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1])) {
                continue;
            }
            currList.add(nums[i]);
            visited[i] = true;
            backtrack(idx + 1, nums, currList, visited);
            currList.remove(idx);
            visited[i] = false;
        }
    }
}
