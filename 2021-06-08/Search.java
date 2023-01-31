package haiwaitu.t20210608;

/**
 * @Author huangjunqiao
 * @Date 2021/06/10 04:39
 * @Description 704. 二分查找
 */
public class Search {
    public int search(int[] nums, int target) {
        // 二分，时间O(logN)，空间O(1)
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
