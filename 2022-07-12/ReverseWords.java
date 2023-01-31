package haiwaitu.t20220712;

/**
 * @Author huangjunqiao
 * @Date 2022/07/12 16:25
 * @Description 557. 反转字符串中的单词 III
 */
public class ReverseWords {
    StringBuilder res = new StringBuilder();
    public String reverseWords(String s) {
        // 双指针，时间：O(n)，空间：O(n)
        int n = s.length();
        int l = 0, r = 0;
        while (r < n) {
            while (r < n && s.charAt(r) != ' ') {
                r++;
            }
            reverse(s, l, r - 1);
            if (r < n) {
                res.append(' ');
            }
            r++;
            l = r;
        }
        return res.toString();
    }
    public void reverse(String s, int start, int end) {
        for (int i = end; i >= start; i--) {
            res.append(s.charAt(i));
        }
    }
}
