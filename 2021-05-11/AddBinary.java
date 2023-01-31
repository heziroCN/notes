package haiwaitu.t20210511;

/**
 * @Author huangjunqiao
 * @Date 2021/05/11 17:49
 * @Description 67. 二进制求和
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        // 模拟加法，逐位相加，记录进位，短的字符串后面补0
        StringBuilder sb = new StringBuilder();
        int n = Math.max(a.length(), b.length());
        int carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            sb.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        // 如果还有进位，加到结果上
        if (carry > 0) {
            sb.append('1');
        }
        return sb.reverse().toString();

    }
    public static String addBinary0(String a, String b) {
        // 位运算解法，直接转整数会溢出
        int sum = 0;
        int carry = 0;
        int numA = str2Binary(a);
        int numB = str2Binary(b);
        do {
            sum = numA ^ numB;
            carry = (numA & numB) << 1;
            numA = sum;
            numB = carry;
        } while (numB != 0);
        return Integer.toBinaryString(numA);
    }
    public static int str2Binary(String s) {
        int num = 0;
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            num += (s.charAt(i) - '0') << cnt;
            cnt++;
        }
        return num;
    }
}
