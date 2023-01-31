package haiwaitu.t20211221;

/**
 * @Author huangjunqiao
 * @Date 2021/12/21 15:22
 * @Description 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        // 时间：O(logN)，空间：O(1)
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        int l = searchFirst(nums, target);
        int r = searchLast(nums, target);
        return new int[]{l, r};
    }
    public int searchFirst(int[] nums, int tar) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (tar > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l] == tar ? l : -1;
    }
    public int searchLast(int[] nums, int tar) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (tar < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return nums[l] == tar ? l : -1;
    }
}
