package haiwaitu.t20220116;

/**
 * @Author huangjunqiao
 * @Date 2022/01/16 20:34
 * @Description 5194. 得到目标值的最少行动次数
 */
public class MinMoves {
    public int minMoves(int target, int maxDoubles) {
        // 贪心，因为翻倍次数有限，所以尽可能把翻倍留在后面
        int res = 0;
        while (target > 1) {
            if (maxDoubles == 0) {
                res += target - 1;
                break;
            }
            if ((target & 1) == 1) {
                target--;
            } else {
                target >>= 1;
                maxDoubles--;
            }
            res++;
        }
        return res;
    }
}
