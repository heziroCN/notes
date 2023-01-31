package haiwaitu.t20210608;

/**
 * @Author huangjunqiao
 * @Date 2021/06/10 05:13
 * @Description 35. 搜索插入位置
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        // 二分，时间O(logN)，空间O(1)
        // target比数组数字都大时，应该插入最右边，所以右边界应该是len而不是len-1
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
