package haiwaitu.t20210617;

/**
 * @Author huangjunqiao
 * @Date 2021/06/18 13:22
 * @Description 283. 移动零
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        // 双指针，时间O(N)，空间O(1)
        int len = nums.length;
        // 左指针停留在遇到的第一个0，右指针找到第一个非0元素后与左指针swap
        int l = 0, r = 0;
        while (r < len) {
            if (nums[r] != 0) {
                swap(nums, l, r);
                l++;
            }
            r++;
        }
    }
    public void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}
