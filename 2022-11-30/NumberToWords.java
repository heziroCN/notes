package haiwaitu.t20221130;

/**
 * @Author huangjunqiao
 * @Date 2022/11/30 22:11
 * @Description 273. 整数转换英文表示
 */
public class NumberToWords {
    String[] singles = new String[] {"", "One", "Two","Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = new String[] {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = new String[] {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 3, unit = 1_000_000_000; i >= 0; i--, unit /= 1000) {
            int currNum = num / unit;
            if (currNum > 0) {
                num -= currNum * unit;
                res.append(toEn(currNum)).append(thousands[i]).append(" ");
            }
        }
        return res.toString().trim();
    }
    public String toEn(int num) {
        StringBuilder sb = new StringBuilder();
        int hundred = num / 100;
        if (hundred > 0) {
            sb.append(singles[hundred]).append(" Hundred ");
        }
        num -= hundred * 100;
        if (num >= 20) {
            int ten = num / 10;
            sb.append(tens[ten]).append(" ");
            num -= ten * 10;
        }
        if (num >= 10 && num < 20) {
            sb.append(teens[num - 10]).append(" ");
        } else if (num > 0 && num < 10) {
            sb.append(singles[num]).append(" ");
        }
        return sb.toString();
    }
}
