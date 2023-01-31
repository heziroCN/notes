package haiwaitu.t20220228;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2022/03/01 00:49
 * @Description 743. 网络延迟时间
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        // dijkstra算法，时间：O(n^2 + m)，空间：O(n^2)，m为times长度
        int INF = Integer.MAX_VALUE / 2;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], INF);
        }
        for (int[] t : times) {
            int x = t[0] - 1, y = t[1] - 1;
            g[x][y] = t[2];
        }
        boolean[] used = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        for (int i = 0; i < n; i++) {
            int x = -1;// 未访问过且距离起点最近的点
            for (int y = 0; y < n; y++) {
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }
            used[x] = true;
            for (int y = 0; y < n; y++) {
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
            }
        }
        int res = 0;
        for (int d : dist) {
            res = Math.max(res, d);
        }
        return res == INF ? -1 : res;
    }
}
