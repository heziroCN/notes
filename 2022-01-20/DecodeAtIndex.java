package haiwaitu.t20220120;

/**
 * @Author huangjunqiao
 * @Date 2022/01/20 16:31
 * @Description 880. 索引处的解码字符串
 */
public class DecodeAtIndex {
    public String decodeAtIndex(String s, int k) {
        // 逆向工作，时间：O(n)，空间：O(1)
        int len = s.length();
        long size = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                size++;
            } else {
                size *= c - '0';
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            k %= size;
            if (k == 0 && Character.isLetter(c)) {
                return String.valueOf(c);
            }
            if (Character.isLetter(c)) {
                size--;
            } else {
                size /= c - '0';
            }
        }
        return null;
    }
}
