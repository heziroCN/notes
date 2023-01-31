package haiwaitu.t20220119;

/**
 * @Author huangjunqiao
 * @Date 2022/01/19 11:22
 * @Description 892. 三维形体的表面积
 */
public class SurfaceArea {
    public int surfaceArea(int[][] grid) {
        // 时间：O(n^2)，空间：O(1)
        int res = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v0 = grid[i][j];
                if (v0 == 0) {
                    continue;
                }
                res += 2 + v0 * 4;
                if (j - 1 >= 0) {
                    res -= Math.min(v0, grid[i][j - 1]);
                }
                if (j + 1 < n) {
                    res -= Math.min(v0, grid[i][j + 1]);
                }
                if (i - 1 >= 0) {
                    res -= Math.min(v0, grid[i - 1][j]);
                }
                if (i + 1 < n) {
                    res -= Math.min(v0, grid[i + 1][j]);
                }
            }
        }
        return res;
    }
}
