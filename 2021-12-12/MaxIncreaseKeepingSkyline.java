package haiwaitu.t20211212;

/**
 * @Author huangjunqiao
 * @Date 2021/12/13 15:36
 * @Description 807. 保持城市天际线
 */
public class MaxIncreaseKeepingSkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        // 贪心，时间：O(n^2)，空间：O(n)
        int n = grid.length;
        int[] rowHighest = new int[n];
        int[] colHighest = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowHighest[i] = Math.max(rowHighest[i], grid[i][j]);
                colHighest[j] = Math.max(colHighest[j], grid[i][j]);
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.min(rowHighest[i], colHighest[j]) - grid[i][j];
            }
        }
        return res;
    }
}
