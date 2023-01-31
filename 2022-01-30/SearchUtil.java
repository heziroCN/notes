package haiwaitu.t20220130;

/**
 * @Author huangjunqiao
 * @Date 2022/01/31 15:58
 * @Description
 */
public class SearchUtil {
    /**
     * 找到有序数组 nums 中第一个严格大于 x 的元素的索引
     */
    public int upperBound(int[] nums, int x) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] <= x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l] > x ? l : -1;
    }

    /**
     * 找到有序数组 nums 中第一个大于等于 x 的元素的索引
     */
    public int lowerBound(int[] nums, int x) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l] == x ? l : -1;
    }

}
