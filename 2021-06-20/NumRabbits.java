package haiwaitu.t20210620;

/**
 * @Author huangjunqiao
 * @Date 2021/06/21 11:35
 * @Description 781. 森林中的兔子
 */
public class NumRabbits {
    public int numRabbits(int[] answers) {
        // 基于数组的贪心+剪枝，时间O(N)，空间O(K)，K为数组最大长度
        // rabbits[i]表示有几个兔子回答还有i只兔子同色
        int[] rabbits = new int[1000];
        // 统计相同颜色的兔子数
        for (int num : answers) {
            rabbits[num]++;
        }
        // 统计总数
        int cnt = 0;
        for (int i = 0; i < 1000; i++) {
            // 1、求最少数量，应该使回答了相同数字的兔子尽量同色
            // 2、森林里能报rabbits[i]的兔子总数，为(i+1)的倍数
            if (rabbits[i] != 0) {
                // 综上1、2，需要计算大于等于rabbit[i]的(i + 1)倍数，如rabbit[10]=3，则3/11=0,(1+0)*11=11，即cnt+=11
                cnt += powerOfN(rabbits[i], i + 1);
            }
        }
        return cnt;
    }
    public int powerOfN(int num, int power) {
        // 计算刚好比num大的power倍数
        if (num % power == 0) {
            return num;
        } else {
            return (1 + num / power) * power;
        }
    }
}
