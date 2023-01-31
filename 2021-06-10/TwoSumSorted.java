package haiwaitu.t20210610;

/**
 * @Author huangjunqiao
 * @Date 2021/06/11 02:06
 * @Description 167. 两数之和 II - 输入有序数组
 */
public class TwoSumSorted {
    public int[] twoSum(int[] numbers, int target) {
        // 二分解法，时间O(NlogN)，空间O(1)
        int[] ans = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int another = search(numbers, target, i);
            if (another != -1) {
                ans[0] = i + 1;
                ans[1] = another + 1;
                break;
            }
        }
        return ans;
    }
    public int search(int[] nums, int target, int curr) {
        int l = curr, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target - nums[curr] && mid != curr) {
                return mid;
            } else if (nums[mid] > target - nums[curr]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
    public int[] twoSum0(int[] numbers, int target) {
        // 双指针解法，时间O(N)，空间O(1)
        int len = numbers.length;
        int min = 0, max = len - 1;
        int[] ans = new int[2];
        // 不能用相同的元素，所以是<而不是<=
        while (min < max) {
            if (numbers[min] + numbers[max] == target) {
                ans[0] = min + 1;
                ans[1] = max + 1;
                break;
            } else if (numbers[min] + numbers[max] < target) {
                min++;
            } else {
                max--;
            }
        }
        return ans;
    }
}
