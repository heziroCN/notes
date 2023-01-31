package haiwaitu.t20220203;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2022/02/04 22:07
 * @Description 拓扑排序
 */
public class TopologicalSorting {
    public List<Integer> topologyBfs(int[][] graph, int n) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int[] g : graph) {
            edges.get(g[0]).add(g[1]);
            indegree[g[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            res.add(u);
            for (int v : edges.get(u)) {
                if (--indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        return res;
    }
}
