package haiwaitu.t20220203;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2022/02/04 22:05
 * @Description 图是否有环
 */
public class DAGCircle {
    List<List<Integer>> edges = new ArrayList<>();
    public boolean hasCircleBfs(int[][] graph, int n) {
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int[] g : graph) {
            edges.get(g[0]).add(g[1]);
            indegree[g[1]]++;
        }


        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            cnt++;
            for (int v : edges.get(u)) {
                if (--indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        return cnt != n;
    }

    boolean hasCircle = false;
    int[] visited;// 0-未访问，1-访问中，2-已访问
    public boolean hasCircleDfs(int[][] graph, int n) {
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] g : graph) {
            edges.get(g[0]).add(g[1]);
        }
        visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (hasCircle) {
                return true;
            } else {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }
        }
        return hasCircle;
    }
    public void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
            } else if (visited[v] == 1) {
                hasCircle = true;
                return;
            }
        }
        visited[u] = 2;
    }
}
