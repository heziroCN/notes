package haiwaitu.t20210622;

/**
 * @Author huangjunqiao
 * @Date 2021/06/23 08:15
 * @Description 11. 盛最多水的容器
 */
public class MaxArea {
    public int maxArea(int[] height) {
        // 双指针，为了得到最大容积，每次将高度较低的边向另一边移动，时间O(N)，空间O(1)
        int max = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int size = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(size, max);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
