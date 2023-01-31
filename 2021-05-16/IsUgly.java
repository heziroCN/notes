package haiwaitu.t20210516;

/**
 * @Author huangjunqiao
 * @Date 2021/05/17 17:53
 * @Description 263. 丑数
 */
public class IsUgly {
    public boolean isUgly(int n) {
        // 理解丑数定义即可，难度不大
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else if (n % 3 == 0) {
                n /= 3;
            } else if (n % 5 == 0) {
                n /= 5;
            } else {
                return false;
            }
        }
        return n == 1;
    }
}
