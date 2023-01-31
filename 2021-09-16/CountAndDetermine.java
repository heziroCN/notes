package haiwaitu.t20210916;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/09/16 14:22
 * @Description 位运算-计算/判断
 */
public class CountAndDetermine {
    /**
     * 计算数字中1的数量
     *
     * @param num
     * @return
     */
    public int count1Num(int num) {
        // num & (num-1)会将num最低位的1置0
        int cnt = 0;
        while (num > 0) {
            num &= (num - 1);
            cnt++;
        }
        return cnt;
    }

    /**
     * 计算数字是否2的非负整数次幂
     *
     * @param num
     * @return
     */
    public boolean isPowerOf2(int num) {
        // 解法1：正数反码为按位取反然后+1，则反码&num结果为num
        return num > 0 && (num & -num) == num;
        // 解法2：num & (num-1)将num最低位的1置0，2的幂唯一一个1的有效位，置0后num=0
//        return num > 0 && (num & (num - 1)) == 0;
    }

    /**
     * 删除最低有效位
     *
     * @param num
     * @return
     */
    public int deleteLowestBit(int num) {
        return num >> 1;
    }

    /**
     * 遍历数字所有非空子集，如输入'101'，返回'001'，'100'，'101'
     *
     * @param num
     * @return
     */
    public List<Integer> allSubset(int num) {
        // 时间：O(3^k)，k为二进制中1的数量
        List<Integer> list = new ArrayList<>();
        for (int sub = num; sub > 0; sub = (sub - 1) & num) {
            list.add(sub);
        }
        return list;
    }

}
