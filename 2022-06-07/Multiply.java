package haiwaitu.t20220607;

/**
 * @Author huangjunqiao
 * @Date 2022/06/08 00:49
 * @Description 43. 字符串相乘
 */
public class Multiply {
     StringBuilder res = new StringBuilder();
     public String multiply(String num1, String num2) {
         // 模拟竖式-动态字符串，时间：O(m(m+n))，空间：O(m+n)
         if ("0".equals(num1) || "0".equals(num2)) {
             return "0";
         }
         int m = num1.length(), n = num2.length();
         for (int i = m - 1; i >= 0; i--) {
             StringBuilder curr = new StringBuilder();
             for (int j = m - 1; j > i; j--) {
                 curr.append('0');
             }
             int x = num1.charAt(i) - '0';
             int carry = 0;
             for (int j = n - 1; j >= 0; j--) {
                 int y = num2.charAt(j) - '0';
                 int product = x * y + carry;
                 curr.append(product % 10);
                 carry = product / 10;
             }
             if (carry > 0) {
                 curr.append(carry);
             }
             res = addStrings(res, curr.reverse());
         }

         return res.toString();
     }
     public StringBuilder addStrings(StringBuilder num1, StringBuilder num2) {
         int i = num1.length() - 1, j = num2.length() - 1;
         int carry = 0;
         StringBuilder sum = new StringBuilder();
         while (i >= 0 || j >= 0) {
             int num = carry;
             num += i >= 0 ? num1.charAt(i) - '0' : 0;
             num += j >= 0 ? num2.charAt(j) - '0' : 0;
             sum.append(num % 10);
             carry = num / 10;
             if (i >= 0) {
                 i--;
             }
             if (j >= 0) {
                 j--;
             }
         }
         if (carry > 0) {
             sum.append(carry);
         }
         return sum.reverse();
     }

    public String multiply0(String num1, String num2) {
        // 用数组逐位相乘，时间：O(mn)，空间：O(m+n)
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] arr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                arr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            arr[i - 1] += arr[i] / 10;
            arr[i] %= 10;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < m + n; i++) {
            if (i == 0 && arr[i] == 0) {
                continue;
            }
            res.append(arr[i]);
        }
        return res.toString();
    }
}
