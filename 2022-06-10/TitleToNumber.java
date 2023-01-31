package haiwaitu.t20220609;

/**
 * @Author huangjunqiao
 * @Date 2022/06/09 16:35
 * @Description 171. Excel 表列序号
 */
public class TitleToNumber {
    public int titleToNumber(String columnTitle) {
        // 时间：O(n)，空间：O(1)
        int res = 0;
        for (char c : columnTitle.toCharArray()) {
            int num = c - 'A' + 1;
            res = res * 26 + num;
        }
        return res;
    }
}
