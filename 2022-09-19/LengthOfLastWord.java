package haiwaitu.t20220919;

/**
 * @Author huangjunqiao
 * @Date 2022/09/19 22:40
 * @Description 58. 最后一个单词的长度
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // 时间：O(n)，空间：O(1)
        int n = s.length();
        int r = n - 1;
        while (r >= 0 && s.charAt(r) == ' ') {
            r--;
        }
        int l = r;
        while (l >= 0 && s.charAt(l) != ' ') {
            l--;
        }
        return r - l;
    }
}
