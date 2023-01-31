package haiwaitu.t20220605;

/**
 * @Author huangjunqiao
 * @Date 2022/06/05 18:17
 * @Description 277. 搜寻名人
 */
public class Solution {
    // 贪心，忽略knows的复杂度，时间：O(n)，空间：O(1)
    public int findCelebrity(int n) {
        int res = 0;
        // 寻找可能的名人
        for (int i = 0; i < n; i++) {
            if (knows(res, i)) {
                res = i;
            }
        }
        // 校验res是否符合名人的标准
        for (int i = 0; i < n; i++) {
            if (i == res) {
                continue;
            }
            if (!knows(i, res) || knows(res, i)) {
                return -1;
            }
        }
        return res;
    }
    public boolean knows(int a, int b) {
        return false;
    }
}
