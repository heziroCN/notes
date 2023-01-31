package haiwaitu.t20211030;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2021/10/30 17:09
 * @Description 869. 重新排序得到 2 的幂
 */
public class ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int n) {
        // 回溯，同类题：47. 全排列 II
        char[] nums = Integer.toString(n).toCharArray();
        boolean[] visited = new boolean[nums.length];

        Arrays.sort(nums);// 排序方便去重，去重原理参见 47. 全排列 II
        return backtrack(0, nums, visited, 0);
    }
    public boolean backtrack(int idx, char[] nums, boolean[] visited, int currNum) {
        int len = nums.length;
        if (idx == len) {
            return isPowerOf2(currNum);
        }
        for (int i = 0; i < len; i++) {
            if ((currNum == 0 && nums[i] == '0') || visited[i] || (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            if (backtrack(idx + 1, nums, visited, currNum * 10 + nums[i] - '0')) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
    public boolean isPowerOf2(int num) {
        return (num & (num - 1)) == 0;
    }
}
