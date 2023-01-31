package haiwaitu.t20211219;

/**
 * @Author huangjunqiao
 * @Date 2021/12/19 12:34
 * @Description 5956. 找出数组中的第一个回文字符串
 */
public class FirstPalindrome {
    public String firstPalindrome(String[] words) {
        // 时间：O(NS)，空间：O(1)，N为字符串数量，S为字符串长度
        for (String s : words) {
            if (isPalindrome(s)) {
                return s;
            }
        }
        return "";
    }
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
