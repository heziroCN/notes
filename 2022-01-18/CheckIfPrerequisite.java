package haiwaitu.t20220118;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2022/01/19 15:08
 * @Description 1462. 课程表 IV
 */
public class CheckIfPrerequisite {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        // 时间：O(qn)，空间：O(m+n)，q为查询对数量，n为课程数，m为先修课程对数量
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            edges.get(pre[0]).add(pre[1]);
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(false);
            Queue<Integer> q = new LinkedList<>();
            q.offer(query[0]);
            Set<Integer> visited = new HashSet<>();
            while (!q.isEmpty()) {
                int c0 = q.poll();
                if (visited.contains(c0)) {
                    continue;
                }
                visited.add(c0);
                for (int c1 : edges.get(c0)) {
                    if (c1 == query[1]) {
                        res.set(res.size() - 1 ,true);
                        break;
                    }
                    q.offer(c1);
                }
            }
        }
        return res;
    }
}
