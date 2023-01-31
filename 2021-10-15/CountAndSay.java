package haiwaitu.t20211015;

/**
 * @Author huangjunqiao
 * @Date 2021/10/15 22:49
 * @Description 38. 外观数列
 */
public class CountAndSay {
    public String countAndSay(int n) {
        // 时间：O(nM)，空间：O(M)，M为字符串最大长度
        String s = "1";//存储当前数字，第一项是1
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int idx = 0;
            while (idx < s.length()) {
                // 相邻且相同的数字归为一组，初始化数量为1
                int cnt = 1, num = s.charAt(idx) - '0';
                while (idx < s.length() - 1 && s.charAt(idx) == s.charAt(idx + 1)) {
                    cnt++;
                    idx++;
                }
                sb.append(cnt);
                sb.append(num);
                idx++;
            }
            // 更新当前外观序列
            s = sb.toString();
        }
        return s;
    }
}
