package haiwaitu.t20210610;

/**
 * @Author huangjunqiao
 * @Date 2021/06/11 02:14
 * @Description 278. 第一个错误的版本
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        // 二分解法，时间O(NlogN)，空间O(1)
        int l = 1, r = n;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (isBadVersion(mid)) {
                // mid为错误版本，说明第一个错误版本为mid或在mid左边
                r = mid;
            } else {
                // mid为正确版本，说明第一个错误版本在mid右边
                l = mid + 1;
            }
        }
        return l;
    }

    boolean isBadVersion(int version) {
        // mock
        return false;
    }
}
