package haiwaitu.t20221211;

/**
 * @Author huangjunqiao
 * @Date 2022/12/11 16:24
 * @Description 26. 删除有序数组中的重复项
 */
public class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        // 双指针：时间：O(n)，空间：O(1)。
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int i = 1, j = 1;
        while (j < n) {
            if (nums[j] != nums[j - 1]) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}
