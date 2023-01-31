package haiwaitu.t20220923;

/**
 * @Author huangjunqiao
 * @Date 2022/09/23 00:21
 * @Description 9. 回文数
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        // 时间：O(logn)，空间：O(1)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revert = 0;
        while (x > revert) {
            revert = (revert * 10) + x % 10;
            x /= 10;
        }
        return x == revert || x == revert / 10;
    }
}
