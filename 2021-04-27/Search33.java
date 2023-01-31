package haiwaitu.t20210427;

import java.lang.reflect.Proxy;

/**
 * @Author huangjunqiao
 * @Date 2021/04/27 12:41
 * @Description 33. 搜索旋转排序数组
 */
public class Search33 {
    /**
     * 有序数组找出特定数字，首先想到使用二分查找。
     * 查找区间[l,r]，区间中点mid=(l+r)/2,[l,mid],[mid,r]至少有一个区间是有序的，
     * 如果target在有序区间，搜索范围缩小至一半
     * 如不在，搜索范围也可以缩小至一半
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (target == nums[mid]) {
                return mid;
            }
            // [l,mid],[mid,r]两个至少有一个是有序的
            // 注意区间r=l+1时，mid=l，这里要用>=不能用>
            if (nums[mid] >= nums[l]) {
                // 如果[l,mid]有序且target位于有序区间，搜索范围缩小至[l, mid - 1]，否则继续搜索[mid + 1, r]
                if (target < nums[mid] && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // [mid,r]有序且target位于有序区间，搜索范围缩小至[mid + 1, r]，否则继续搜索[l, mid - 1]
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,1,3};
        System.out.println(search(nums,3));

    }
}
