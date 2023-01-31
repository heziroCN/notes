package haiwaitu.t20220607;

/**
 * @Author huangjunqiao
 * @Date 2022/06/07 22:34
 * @Description 41. 缺失的第一个正数
 */
public class FirstMissingPositive {
    /**
     * 将所有数字分[1,n]和[n + 1, max]两部分处理，利用输入数组记录[1,n]中存在的数字，如果
     * [1,n]所有数字都存在，只有一种情况：1~n所有数字均出现一次，没有出现过的最小正整数为n+1
     */
    public int firstMissingPositive(int[] nums) {
        // 使用“取负数”标记[1,n]中存在的数，时间：O(n)，空间：O(1)
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public int firstMissingPositive0(int[] nums) {
        // 通过原地交换标记[1,n]中存在的数，时间：O(n)，空间：O(1)
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != nums[i] - 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
    public void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}
