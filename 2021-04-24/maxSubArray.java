package haiwaitu.t20210424;

/**
 * @Author huangjunqiao
 * @Date 2021/04/24 16:32
 * @Description 53. 最大子序和
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        // 分治
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] nums, int l, int r) {
        if (l == r) {
             // 长度为1的子区间，lSum,rSum,iSum,mSum均为nums[l]的值
            return new Status(nums[l], nums[l], nums[l], nums[l]);
        }
        // 以中间为分界线，递归处理左右子区间
        int m = (l + r) >> 1;
        Status lStatus = getInfo(nums, l, m);
        Status rStatus = getInfo(nums,m + 1, r);
        // 实际计算lSum,rSum，mSum,iSum的值
        return pushUp(lStatus, rStatus);
    }

    /**
     * lSum可能是左子区间的lSum，也可能跨越了m点，为左子区间的iSum与右子区间lSum的和；
     * rSum可能是右子区间的rSum，也可能跨域了m点，为右子区间的iSum与左子区间rSum的和；
     * 在没跨越m点情况下，mSum可能是左子区间的mSum，也可能是右子区间的mSum；若跨域了m点，
     * mSum为左子区间rSum与右子区间lSum之和，mSum取三者最大值；
     * iSum最简单，直接取左右子区间iSum之和即可。
     * @param l
     * @param r
     * @return
     */
    public Status pushUp(Status l, Status r) {
        int lSum = Math.max(l.lSum, (l.iSum + r.lSum));
        int rSum = Math.max(r.rSum, (r.iSum + l.rSum));
        int mSum = Math.max(l.mSum, Math.max(r.mSum, l.rSum + r.lSum));
        int iSum = l.iSum + r.iSum;
        return new Status(lSum, rSum, mSum, iSum);
    }

    /**
     * 辅助类，lSum 表示 [l,r]内以 ll 为左端点的最大子段和
     * rSum 表示 [l,r]内以 rr 为右端点的最大子段和
     * mSum 表示 [l,r]内的最大子段和
     * iSum 表示 [l,r] 的区间和
     *
     */
    public class Status {
        public int lSum, rSum, mSum, iSum;
        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public int maxSubArray0(int[] nums) {
        // 前缀和
        int len = nums.length;
        int[] prefix = new int[len + 1];
        for (int i = 0; i < len; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int min = Integer.MAX_VALUE, max = nums[0];
        for (int i = 1; i <= len; i++) {
            min = Math.min(min, prefix[i]);
            max = Math.max(max, prefix[i] - min);
        }
        return max;
    }

     public int maxSubArray1(int[] nums) {
         // 动态规划，时间：O(N)，空间：O(1)
         int len = nums.length;
         int[] dp = new int[len];// dp[i] 为以nums[i]结尾的最大子数组和
         dp[0] = nums[0];
         int max = dp[0];
         for (int i = 1; i < len; i++) {
             dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
             max = Math.max(max, dp[i]);
         }
         return max;
     }

}
