package haiwaitu.t20210517;

/**
 * @Author huangjunqiao
 * @Date 2021/05/17 17:33
 * @Description 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    public int[] searchRange0(int[] nums, int target) {
        // 二分查找+中心拓展，最坏情况下O(N)，最好情况O(logN)
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int l = 0;
        int r = nums.length - 1;
        int findIndex = -1;
        while (l <= r && findIndex == -1) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                findIndex = mid;
                break;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (findIndex == -1) {
            return result;
        }

        int start = findIndex;
        int end = findIndex;
        while (start > 0) {
            if (nums[start - 1] != target) {
                break;
            }
            start--;
        }
        while (end < nums.length - 1) {
            if (nums[end + 1] != target) {
                break;
            }
            end++;
        }
        result[0] = start;
        result[1] = end;
        return result;
    }

    public int[] searchRange1(int[] nums, int target) {
        // 二分查找（官解：找target最左和仅仅比target大的最左下标-1）O(logN)
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }
    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        // 二分查找(直接找最左和最右) O(logN)
        int leftIdx = findLeft(nums, 0, nums.length - 1, target);
        int rightIdx = findRight(nums, 0, nums.length - 1, target);
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }
    public int findLeft(int[] nums, int l, int r, int target) {
        while (l < r) {
            int mid = (l + r) >> 1;
            if (target <= nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    public int findRight(int[] nums, int l, int r, int target) {
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (target >= nums[mid]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
