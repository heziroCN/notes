package haiwaitu.t20211018;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/10/19 02:23
 * @Description 207. 课程表
 */
public class CanFinish {
    List<List<Integer>> edges = new ArrayList<>();
    boolean valid = true;// 是否能完成所有课程（图是否有环）
    int[] visited;// 是否访问过，0-未访问，1-访问中，2-已访问
     public boolean canFinish0(int numCourses, int[][] prerequisites) {
         // dfs解法，将课程视为节点，在搜索时每个节点有三种状态：未访问，访问中和已访问，如果遍历时遇到状态为访问中的相邻节点，说明图有环，无法完成所有课程。时间：O(MN)，空间：O(M)，M为prerequisites长度，N为课程数。
         for (int i = 0; i < numCourses; i++) {
             edges.add(new ArrayList<>());
         }
         for (int[] course : prerequisites) {
             edges.get(course[1]).add(course[0]);
         }
         visited = new int[numCourses];
         for (int i = 0; i < numCourses; i++) {
             if (!valid) {
                 return false;
             }
             if (visited[i] == 0) {
                 dfs(i);
             }
         }
         return valid;
     }
     public void dfs(int u) {
         visited[u] = 1;
         for (int v : edges.get(u)) {
             if (visited[v] == 0) {
                 dfs(v);
             } else if (visited[v] == 1) {
                 valid = false;
                 return;
             }
         }
         visited[u] = 2;
     }

    int[] indeg;// indeg[i]存储课程i「当前」还需要多少先修课程
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // bfs解法，把访问过的课程视为已修，搜索过程中记录每门课「当前」还需要多少先修课程，把可以开始修（即修完需要的先修课）的课程加入队列，并记录已修课程数。
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        indeg = new int[numCourses];
        for (int[] course : prerequisites) {
            edges.get(course[1]).add(course[0]);
            indeg[course[0]]++;
        }
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        int hasStudy = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            hasStudy++;
            for (int v : edges.get(u)) {
                indeg[v]--;// 修完课程u，v需要的先修课程-1
                if (indeg[v] == 0) {
                    q.offer(v);
                }
            }
        }
        return hasStudy == numCourses;
    }

}
