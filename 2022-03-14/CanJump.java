package haiwaitu.t20220314;

/**
 * @Author huangjunqiao
 * @Date 2022/03/14 17:00
 * @Description 55. 跳跃游戏
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        // 时间：O(n)，空间：O(1)
        int n = nums.length, farthest = 0;
        for (int i = 0; i < n; i++) {
            if (farthest >= i) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            if (farthest >= n - 1) {
                return true;
            }
        }
        return false;
    }
}
