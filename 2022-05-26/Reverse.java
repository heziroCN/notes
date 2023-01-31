package haiwaitu.t20220526;

/**
 * @Author huangjunqiao
 * @Date 2022/05/26 16:11
 * @Description 7. 整数反转
 */
public class Reverse {
    public int reverse(int x) {
        // 时间：O(n)，空间：O(1)
        int res = 0;
        while (x != 0) {
            int num = x % 10;
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            res *= 10;
            res += num;
            x /= 10;
        }
        return res;
    }
}
