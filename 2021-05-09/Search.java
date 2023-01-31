package haiwaitu.t20210509;

/**
 * @Author huangjunqiao
 * @Date 2021/05/09 08:45
 * @Description 81. 搜索旋转排序数组 II
 */
public class Search {
    public static boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return nums[0] == target;
        }
        int l = 0, r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = (l + r) >> 1;
            if (target == nums[mid]) {
                return true;
            }
            // 相比无重复旋转数组一定有一个子区间递增，这里要多一种情况
            // 1、[l,mid]递增，[mid + 1,r]不是
            // 2、[mid+1,r]递增，[l,mid]不是
            // 3、都不递增（可能两个区间都是重复数字，也可能一个重复一个旋转）
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                // 都不递增，只能l+1，r-1继续二分
                ++l;
                --r;
            } else if (nums[mid] >= nums[l]) {
                // [l,mid]递增，[mid + 1,r]不是
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // [mid+1,r]递增，[l,mid]不是
                if (target >= nums[mid] && target < nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
