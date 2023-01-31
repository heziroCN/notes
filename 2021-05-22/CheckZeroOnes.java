package haiwaitu.t20210522;

/**
 * @Author huangjunqiao
 * @Date 2021/05/23 22:52
 * @Description 5763. 哪种连续子字符串更长(242周赛)
 */
public class CheckZeroOnes {
    public boolean checkZeroOnes(String s) {
        int len1 = 0;
        int len0 = 0;
        int idx = 0;
        int currLen1 = 0;
        int currLen0 = 0;
        while (idx < s.length()) {

            if (s.charAt(idx) == '1') {
                len0 = Math.max(currLen0, len0);
                currLen0 = 0;
                currLen1++;
                idx++;
            } else {
                len1 = Math.max(currLen1, len1);
                currLen1 = 0;
                currLen0++;
                idx++;
            }
        }
        len0 = Math.max(currLen0, len0);
        len1 = Math.max(currLen1, len1);
        return len1 > len0;
    }

}
