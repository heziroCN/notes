package haiwaitu.t20221129;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2022/11/29 00:04
 * @Description 210. 课程表 II
 */
public class FindOrder {
    public int[] findOrder(int n, int[][] prerequisites) {
        // BFS，时间：O(n+m)，空间：O(n+m)，n为课程数，m为先课程要求数。
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        int[] indeg = new int[n];// 入度
        for (int[] p : prerequisites) {
            edges.get(p[1]).add(p[0]);
            indeg[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        int[] result = new int[n];
        int idx = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            result[idx++] = curr;
            for (int next : edges.get(curr)) {
                indeg[next]--;
                if (indeg[next] == 0) {
                    q.offer(next);
                }
            }
        }
        if (idx < n) {
            return new int[0];
        }
        return result;
    }

    boolean valid = true;// 是否有环
    int[] visited;
    List<List<Integer>> edges;
    int[] result;
    int idx;
    public int[] findOrder0(int n, int[][] prerequisites) {
        // DFS，O(n+m)，空间：O(n+m)，n为课程数，m为先课程要求数
        result = new int[n];
        idx = n - 1;
        edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            edges.get(p[1]).add(p[0]);
        }
        visited = new int[n];
        for (int i = 0; i < n && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid) {
            return new int[0];
        }
        return result;
    }
    public void dfs(int curr) {
        visited[curr] = 1;
        for (int next : edges.get(curr)) {
            if (visited[next] == 0) {
                dfs(next);
            } else if (visited[next] == 1) {
                valid = false;// 有环
                return;
            }
        }
        visited[curr] = 2;
        result[idx--] = curr;
    }
}
