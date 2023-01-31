package haiwaitu.t20220710;

/**
 * @Author huangjunqiao
 * @Date 2022/07/10 18:03
 * @Description 12. 整数转罗马数字
 */
public class IntToRoman {
    public String intToRoman(int num) {
        // 时间：O(1)，空间：O(1)
        int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int n = vals.length;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            while (num >= vals[i]) {
                num -= vals[i];
                res.append(romans[i]);
            }
            if (num == 0) {
                return res.toString();
            }
        }
        return res.toString();
    }
}
