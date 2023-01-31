package haiwaitu.t20210518;

/**
 * @Author huangjunqiao
 * @Date 2021/05/18 21:43
 * @Description 189. 旋转数组
 */
public class Rotate {
    // public void rotate(int[] nums, int k) {
    //     // 暴力解法时间O(n)，空间O(1)，复制到新数组
    //     int len = nums.length;
    //     int[] result = new int[len];
    //     for (int i = 0; i < len; i++) {
    //         result[(i + k) % len] = nums[i];
    //     }
    //     System.arraycopy(result, 0, nums, 0, len);
    // }

    // public void rotate(int[] nums, int k) {
    //     // 两次翻转，时间O(n)，空间O(1)
    //     int len = nums.length;
    //     k %= len;
    //     reverse(nums, 0, len - 1);
    //     reverse(nums, 0, k - 1);
    //     reverse(nums, k, len - 1);
    // }
    // public void reverse(int[] nums, int l, int r) {
    //     int temp = 0;
    //     while (l < r) {
    //         temp = nums[l];
    //         nums[l] = nums[r];
    //         nums[r] = temp;
    //         l++;
    //         r--;
    //     }
    // }


    public void rotate(int[] nums, int k) {
        // 环状替换，时间O(n)，空间O(1)
        int len = nums.length;
        k %= len;
        int count = gcd(len, k);
        for (int start = 0; start < count; start++) {
            int current = start;
            int prev = nums[current];
            do {
                // 先缓存当前数
                int temp = nums[(current + k) % len];
                // 把上一个数填充到当前数的位置
                nums[(current + k) % len] = prev;
                // 用缓存的当前数更新prev指针
                prev = temp;
                current = (current + k) % len;

            } while (current != start);
        }
    }

    public int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
        // 递归实现
//        return y > 0 ? gcd(y, x % y) : x;
    }

}
