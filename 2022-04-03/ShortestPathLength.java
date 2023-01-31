package haiwaitu.t20220402;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author huangjunqiao
 * @Date 2022/04/03 22:17
 * @Description 847. 访问所有节点的最短路径
 */
public class ShortestPathLength {
    public int shortestPathLength(int[][] graph) {
        // 时间：O(n*n*2^n)，空间：O(n*n*2^n)
        int n  = graph.length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] seen = new boolean[n][1 << n];
        for (int i = 0; i < n; i++) {
            q.offer(new int[] {i, 1 << i, 0});
            seen[i][1 << i] = true;
        }
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int u = curr[0], mask = curr[1], dist = curr[2];
            if (mask == (1 << n) - 1) {
                return dist;
            }
            for (int v : graph[u]) {
                int maskV = mask | (1 << v);
                if (!seen[v][maskV]) {
                    q.offer(new int[] {v, maskV, dist + 1});
                    seen[v][maskV] = true;
                }
            }
        }
        return 0;
    }
}
