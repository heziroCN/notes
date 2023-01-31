package haiwaitu.t20220303;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2022/03/04 19:24
 * @Description 785. 判断二分图
 */
public class IsBipartite {
    static final int UNCOLORED = 0;
    static final int RED = 1;
    static final int GREEN = 2;
    int[] color;
    boolean valid;
     public boolean isBipartite(int[][] graph) {
         // DFS，时间：O(m+n)，空间：O(n)，m为边数
         int n = graph.length;
         color = new int[n];
         valid = true;
         for (int i = 0; i < n && valid; i++) {
             if (color[i] == UNCOLORED) {
                 dfs(RED, i, graph);
             }
         }
         return valid;
     }
     public void dfs(int c, int p, int[][] graph) {
         color[p] = c;
         int cNei = (c == RED) ? GREEN : RED;
         for (int pNei : graph[p]) {
             if (color[pNei] == UNCOLORED) {
                 dfs(cNei, pNei, graph);
             } else if (color[pNei] != cNei) {
                 valid = false;
                 return;
             }
             if (!valid) {
                 return;
             }
         }
     }

    public boolean isBipartite0(int[][] graph) {
        // BFS，时间：O(m+n)，空间：O(n)，m为边数
        int n = graph.length;
        color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == UNCOLORED) {
                Deque<Integer> q = new LinkedList<>();
                q.offer(i);
                color[i] = RED;
                while (!q.isEmpty()) {
                    int p = q.poll();
                    int cNei = (color[p] == RED) ? GREEN : RED;
                    for (int pNei : graph[p]) {
                        if (color[pNei] == UNCOLORED) {
                            q.offer(pNei);
                            color[pNei] = cNei;
                        } else if (color[pNei] != cNei) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
