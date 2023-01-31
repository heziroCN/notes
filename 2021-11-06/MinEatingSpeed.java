package haiwaitu.t20211106;

/**
 * @Author huangjunqiao
 * @Date 2021/11/07 05:52
 * @Description 875. 爱吃香蕉的珂珂
 */
public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = 1_000_000_000;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (possible(piles, mid, h)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    public boolean possible(int[] piles, int k, int h) {
        int cost = 0;
        for (int p : piles) {
            cost += (p - 1) / k + 1;
        }
        return cost <= h;
    }
}
