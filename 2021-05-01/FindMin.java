package haiwaitu.t20210501;

/**
 * @Author huangjunqiao
 * @Date 2021/05/01 16:40
 * @Description 153. 寻找旋转排序数组中的最小值
 */
public class FindMin {
    /**
     * 暴力搜索O(n) 直接遍历数组，不断更新最小值即可
     * 二分查找O(logn) 把旋转后的两个区间分为大区间和小区间，最小值位于小区间的首位，左边
     * 是大区间末尾，要在[l,r]内找到最小值，需保证l在大区间，r在小区间，即nums[l]>nums[r]
     * 二分缩减搜索范围时，要保证nums[l]>nums[r]，即区间不是升序的（升序说明区间内有序，
     * 无法确定最小值），需重新指定缩小的边界
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        // 不能用<=，等于的情况继续执行循环体逻辑的话，
        while (l < r) {
            mid = (l + r) >> 1;
            // [l,r]只有两个元素的时候，if(nums[l]<nums[mid])的话，else里的r=mid会跳过最小值
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                // mid+1可以加快搜索而不会跳过最小值
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
