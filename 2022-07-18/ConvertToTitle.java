package haiwaitu.t20220718;

/**
 * @Author huangjunqiao
 * @Date 2022/07/18 19:04
 * @Description 168. Excel表列名称
 */
public class ConvertToTitle {
    public String convertToTitle(int columnNumber) {
        // 时间：O(log26(columnNumber))，空间：O(1)
        StringBuilder res = new StringBuilder();
        while (columnNumber != 0) {
            int num = (columnNumber - 1) % 26 + 1;
            res.append((char) (num + 'A' - 1));
            columnNumber = (columnNumber - num) / 26;
        }
        return res.reverse().toString();
    }
}
