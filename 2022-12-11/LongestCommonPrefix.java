package haiwaitu.t20221211;

/**
 * @Author huangjunqiao
 * @Date 2022/12/11 03:09
 * @Description 14. 最长公共前缀
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // 纵向扫描，时间：O(nL)，空间：O(1)，n为字符串数量，L为最长公共前缀
        StringBuilder res = new StringBuilder();
        int idx = 0;
        while (idx < strs[0].length()) {
            char c = strs[0].charAt(idx);
            for (String str : strs) {
                if (idx >= str.length() || c != str.charAt(idx)) {
                    return res.toString();
                }
            }
            res.append(c);
            idx++;
        }
        return res.toString();
    }
}
