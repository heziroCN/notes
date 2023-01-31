package haiwaitu.t20220104;

/**
 * @Author huangjunqiao
 * @Date 2022/01/05 12:28
 * @Description 157. 用 Read4 读取 N 个字符
 */
public class Solution {
    public int read(char[] buf, int n) {
        // 时间：O(N)，空间：O(S)，S为read4连续一次读取的字符数。
        int i = 0, read = 1;
        while (i < n && read > 0) {
            char[] temp = new char[4];
            read = read4(temp);
            for (int j = 0; j < read && i < n; j++) {
                buf[i++] = temp[j];
            }
        }
        return i;
    }

    public int read4(char[] buf) {
        // mock
        return 0;
    }
}
