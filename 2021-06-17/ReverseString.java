package haiwaitu.t20210617;

/**
 * @Author huangjunqiao
 * @Date 2021/06/18 13:21
 * @Description 344. 反转字符串
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            swap(s, l, r);
            l++;
            r--;
        }
    }
    void swap(char[] s, int l, int r) {
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }
}
