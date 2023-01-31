package haiwaitu.t20210618;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2021/06/19 11:43
 * @Description 977. 有序数组的平方
 */
public class SortedSquare {

    /**
     * 由于平方后负数部分数字会变成逆序，数组在正负交界处被分成一个逆序和一个升序的数组，可以定
     * 义两个指针从交界处出发，一个向左一个向右，合并两个有序子区间。类似 88. 合并两个有序数组
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares0(int[] nums) {
        // 双指针+归并，时间O(N)，空间不算结果数组为O(1)。
        int len = nums.length;
        // 找到负数和正数的分界线，如全是负数取最后一个
        int r = 0;
        // 找出正负数的分界线
        while (r < len) {
            if (nums[r] >= 0) {
                break;
            }
            r++;
        }
        int l = r - 1;
        int[] result = new int[len];
        int idx = 0;
        //两指针分别往左和往右扫描，按归并排序合并两个子区间
        while (r < len && l >= 0) {
            if (-nums[l] > nums[r]) {
                result[idx++] = nums[r] * nums[r];
                r++;
            } else {
                result[idx++] = nums[l] * nums[l];
                l--;
            }
        }
        while (l >= 0) {
            result[idx++] = nums[l] * nums[l];
            l--;
        }
        while (r < len) {
            result[idx++] = nums[r] * nums[r];
            r++;
        }
        return result;
    }

    public int[] sortedSquares1(int[] nums) {
        // 双指针逆序扫描，时间O(N)，空间不算结果数组为O(1)。
        // 左指针走到正负分界线时，会因为指向最小的数，而在接下来的循环中等待右指针走过来和他重合
        int l = 0, r = nums.length - 1;
        int[] result = new int[nums.length];
        int idx = nums.length - 1;
        while (l <= r) {
            int lNum = nums[l], rNum = nums[r];
            if (lNum * lNum > rNum * rNum) {
                result[idx--] = lNum * lNum;
                l++;
            } else {
                result[idx--] = rNum * rNum;
                r--;
            }
        }
        return result;
    }

    public int[] sortedSquares(int[] nums) {
        // 排序，时间O(NlogN)，空间O(logN)
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            nums[i] = num * num;
        }
        Arrays.sort(nums);
        return nums;
    }
}
