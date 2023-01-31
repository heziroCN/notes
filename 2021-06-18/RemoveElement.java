package haiwaitu.t20210618;

/**
 * @Author huangjunqiao
 * @Date 2021/06/19 12:03
 * @Description 27. 移除元素
 */
public class RemoveElement {
    /**
     * 原地移除元素，可以视作将目标元素val移到数组末尾，与283. 移动零将0移动到数组末尾非常相似，
     * 区别是这题允许覆盖val并且不需要保持原来的顺序，利用这个特性可以将双指针的两次遍历优化到一次遍历
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        // 双指针两次遍历，时间O(N)，空间O(1)
        int l = 0, r = 0;
        // 右指针元素不等于val，需要保留，移到左边；等于val，则继续向右边寻找需要保留的元素。左指针指向当前用来接收需要保留元素的位置。
        while (r < nums.length) {
            if (nums[r] != val) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;
    }
     public int removeElement0(int[] nums, int val) {
         // 双指针一次遍历，时间O(N)，空间O(1)
         int l = 0, r = nums.length - 1;
         while (l <= r) {
             // 如果右指针元素也是需要移除的元素，在覆盖左指针元素后，右指针会继续左移，找到可以保留的元素才移动左指针
             if (nums[l] == val) {
                 nums[l] = nums[r];
                 r--;
             } else {
                 // 使左指针始终指向需要移除的元素
                 l++;
             }
         }
         return l;
     }
}
