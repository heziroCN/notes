package haiwaitu.t20220424;

/**
 * @Author huangjunqiao
 * @Date 2022/04/24 22:08
 * @Description 6042. 统计圆内格点数目
 */
public class CountLatticePoints {
    public int countLatticePoints(int[][] circles) {
        // 时间：O(Sn)，空间：O(1)，S为数据范围内圆能覆盖到的点数，n为圆的数量
        int res = 0;
        for (int i = -99; i <= 200; i++) {
            for (int j = -99; j <= 200; j++) {
                for (int[] c : circles) {
                    if ((i - c[0]) * (i - c[0]) + (j - c[1]) * (j - c[1]) <= c[2] * c[2]) {
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
