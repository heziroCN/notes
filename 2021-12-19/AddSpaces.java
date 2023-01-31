package haiwaitu.t20211219;

/**
 * @Author huangjunqiao
 * @Date 2021/12/19 12:35
 * @Description 5957. 向字符串添加空格
 */
public class AddSpaces {
    public String addSpaces(String s, int[] spaces) {
        // 双指针，时间：O(N+M)，空间：O(1)，N为字符串长度，M为空格数量
        int len = s.length();
        char[] res = new char[len + spaces.length];
        int idx = 0, i = 0;
        for (int space : spaces) {
            boolean find = false;
            while (i < len) {
                if (space == i) {
                    find = true;
                    res[idx++] = ' ';
                }
                res[idx++] = s.charAt(i++);
                if (find) {
                    break;
                }
            }
        }
        while (i < len) {
            res[idx++] = s.charAt(i++);
        }
        return new String(res);
    }
}
