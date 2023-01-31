package haiwaitu.t20220328;

/**
 * @Author huangjunqiao
 * @Date 2022/03/28 16:07
 * @Description 287. 寻找重复数
 */
public class FindDuplicate {
     public int findDuplicate(int[] nums) {
         // 二分查找，时间：O(nlogn)，空间：O(1)
         int l = 1, r = nums.length - 1;
         while (l < r) {
             int mid = (l + r) >> 1;
             if (countRange(nums, mid) > mid) {
                 r = mid;
             } else {
                 l = mid + 1;
             }
         }
         return l;
     }
     public int countRange(int[] nums, int mid) {
         int cnt = 0;
         for (int num : nums) {
             if (num <= mid) {
                 cnt++;
             }
         }
         return cnt;
     }

    public int findDuplicate0(int[] nums) {
        // 位运算，统计nums中和区间[1,n]中第i位为1的数字个数，分别记为x和y。如果x>y，说明重复数字在第i位为1。时间：O(nlogn)，空间：O(1)
        int maxBit = 31, res = 0;
        int n = nums.length;
        while (((n - 1) >> maxBit) == 0) {
            maxBit--;
        }
        for (int bit = 0; bit <= maxBit; bit++) {
            int x = 0, y = 0;
            for (int i = 0; i < n; i++) {
                if ((nums[i] & (1 << bit)) != 0) {
                    x++;
                }
                if (i != 0 && (i & (1 << bit)) != 0) {
                    y++;
                }
            }
            if (x > y) {
                res |= 1 << bit;
            }
        }
        return res;
    }
    public int findDuplicate1(int[] nums) {
        // 建图+Floyd判圈，时间：O(n)，空间：O(1)
        // 对i -> nums[i] 建图，如没重复数，所有节点入度均为1，图呈现为一个链表，如有一个重复数，则有一个节点入度变成2，形成环。
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
