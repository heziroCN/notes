package haiwaitu.t20220608;

/**
 * @Author huangjunqiao
 * @Date 2022/06/08 17:07
 * @Description 443. 压缩字符串
 */
public class Compress {
    public int compress(char[] chars) {
        // 时间：O(n)，空间：O(1)
        int cnt = 1;
        int n = chars.length, i = 0, j = 0;
        while (i < n) {
            while (i < n - 1 && chars[i] == chars[i + 1]) {
                i++;
                cnt++;
            }
            chars[j++] = chars[i];
            if (cnt > 1) {
                StringBuilder sb = new StringBuilder();
                while (cnt > 0) {
                    sb.append(cnt % 10);
                    cnt /= 10;
                }
                for (int k = sb.length() - 1; k >= 0; k--) {
                    chars[j++] = sb.charAt(k);
                }
            }
            cnt = 1;
            i++;
        }
        return j;
    }
}
