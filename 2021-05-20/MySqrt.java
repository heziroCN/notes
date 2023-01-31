package haiwaitu.t20210520;

/**
 * @Author huangjunqiao
 * @Date 2021/05/20 14:15
 * @Description 69. x 的平方根
 */
public class MySqrt {
    public int mySqrt(int x) {
        // 二分，时间O(logx)，空间O(1)
        int l = 0, r = x;
        int mid;
        int ans = 0;
        while (l <= r) {
            mid = (l + r) >> 1;
            if ((long) mid * mid > x) {
                // 平方根在中点左边
                r = mid - 1;
            } else {
                // 平方根可能在中点右边，也可能就是中点。
                l = mid + 1;
                // 1、平方根刚好是中点时，ans保存了结果。2、平方根在中点右边时，ans保存了可能的结果，如果恰好处于边界时，如x=8,mid=2，在接下来的循环r会不断向左靠拢，l和ans都不会更新，直到l==r。
                ans = mid;
            }
        }
        return ans;
    }
}
