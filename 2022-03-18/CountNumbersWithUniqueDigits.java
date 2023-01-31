package haiwaitu.t20220318;

/**
 * @Author huangjunqiao
 * @Date 2022/03/19 15:00
 * @Description 357. 计算各个位数不同的数字个数
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        // dp，时间：O(n)，空间：O(1)
        if (n == 0) {
            return 1;
        }
        int iGen = 9, cnt = 10;// iGen为区间[10^i,10^(i+1))能产生的不同数字
        if (n == 1) {
            return cnt;
        }
        for (int i = 2; i <= n; i++) {
            iGen *= (10 - (i - 1));//i位数字从[0,9]中选出一个与之前i-1位不同的数字，共有(10-(i-1))种选择
            cnt += iGen;
        }
        return cnt;
    }
}
