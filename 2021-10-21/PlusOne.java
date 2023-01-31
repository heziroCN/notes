package haiwaitu.t20211021;

/**
 * @Author huangjunqiao
 * @Date 2021/10/22 23:33
 * @Description 66. 加一
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        // 时间：O(N)，空间：O(1)
        int len = digits.length;
        int idx = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                continue;
            }
            digits[i]++;
            for (int j = i + 1; j < len; j++) {
                digits[j] = 0;
            }
            return digits;
        }
        // 所有位都是9
        int[] newArr = new int[len + 1];
        newArr[0] = 1;
        return newArr;
    }
}
