package haiwaitu.t20220104;

/**
 * @Author huangjunqiao
 * @Date 2022/01/05 13:44
 * @Description 158. 用 Read4 读取 N 个字符 II
 */
public class Solution2 {
    char[] tmp;
    int tmpIdx = 0;
    int remain = 0;
    public int read(char[] buf, int n) {
        // 时间：O(N)，空间：O(S)，S为read4连续一次读取的字符数
        int i = 0;
        int read = 1;
        while (i < n) {
            if (remain > 0) {
                while (remain > 0 && i < n) {
                    buf[i++] = tmp[tmpIdx++];
                    remain--;
                }
            } else if (read <= 0) {
                break;
            } else {
                tmp = new char[4];
                read = read4(tmp);
                for (tmpIdx = 0; tmpIdx < read && i < n; tmpIdx++) {
                    buf[i++] = tmp[tmpIdx];
                }
                remain = read - tmpIdx;
            }
        }
        return i;
    }
    public int read4(char[] buf) {
        // mock
        return 0;
    }
}
