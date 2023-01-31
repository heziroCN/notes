package haiwaitu.t20211217;

/**
 * @Author huangjunqiao
 * @Date 2021/12/18 23:10
 * @Description 1007. 行相等的最少多米诺旋转
 */
public class MinDominoRotatetions {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // 时间：O(N)，空间：O(1)
        int n = tops.length;
        int r1 = check(tops[0], tops, bottoms, n);
        if (r1 != -1 || tops[0] == bottoms[0]) {// 只要找到一个能平铺的数，这个数字出现次数必定占半数以上，因此最小的翻转次数一定属于它，不需要比较r1和r2大小
            return r1;
        } else {
            return check(bottoms[0], tops, bottoms, n);
        }
    }
    public int check(int x, int[] tops, int[] bottoms, int n) {
        int rotate1 = 0, rotate2 = 0;
        for (int i = 0; i < n; i++) {
            if (tops[i] != x && bottoms[i] != x) {
                return -1;
            } else if (tops[i] != x) {
                rotate1++;
            } else if (bottoms[i] != x) {
                rotate2++;
            }
        }
        return Math.min(rotate1, rotate2);
    }
}
