package haiwaitu.t20211116;

/**
 * @Author huangjunqiao
 * @Date 2021/11/17 22:53
 * @Description 318. 最大单词长度乘积
 */
public class MaxProduct {
    public int maxProduct(String[] words) {
        // 位运算，时间：O(N^2)，空间：O(N)
        int len = words.length;
        int res = 0;
        int[] mask = new int[len];
        for (int i = 0; i < len; i++) {
            String str = words[i];
            for (int j = 0; j < str.length(); j++) {
                mask[i] |= 1 << (str.charAt(j) - 'a');
            }
        }
        for (int i = 0; i < len; i++) {
            String str1 = words[i];
            for (int j = i + 1; j < len; j++) {
                String str2 = words[j];
                if ((mask[i] & mask[j]) == 0) {
                    res = Math.max(res, str1.length() * str2.length());
                }
            }
        }
        return res;
    }
}
