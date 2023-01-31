package haiwaitu.t20220208;

/**
 * @Author huangjunqiao
 * @Date 2022/02/09 00:14
 * @Description 134. 加油站
 */
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 一次遍历，时间：O(n)，空间：O(1)
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int rest = 0, cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                rest += gas[j] - cost[j];
                if (rest < 0) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i += cnt + 1;
            }
        }
        return -1;
    }
}
