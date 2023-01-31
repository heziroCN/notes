package haiwaitu.t20221005;

/**
 * @Author huangjunqiao
 * @Date 2022/10/05 21:24
 * @Description 151. 反转字符串中的单词
 */
public class ReverseWords {
    public String reverseWords(String s) {
        // 双指针，时间：O(n)，空间：O(n)
        int n = s.length();
        int r = n - 1;
        StringBuilder sb = new StringBuilder();
        while (r >= 0) {
            while (r >= 0 && s.charAt(r) == ' ') {
                r--;
            }
            int l = r;
            while (l >= 0 && s.charAt(l) != ' ') {
                l--;
            }
            for (int i = l + 1; i <= r; i++) {
                sb.append(s.charAt(i));
            }
            sb.append(' ');
            r = l;
        }
        while (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
