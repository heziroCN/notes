package haiwaitu.t20210503;

/**
 * @Author huangjunqiao
 * @Date 2021/05/03 22:03
 * @Description 125. 验证回文串
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        // 双指针，时间：O(n)，空间：O(1)
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char lc = s.charAt(l), rc = s.charAt(r);
            if (!Character.isLetterOrDigit(lc)) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(rc)) {
                r--;
                continue;
            }
            if (Character.toUpperCase(lc) != Character.toUpperCase(rc)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
