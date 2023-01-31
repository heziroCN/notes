package haiwaitu.t20220118;

/**
 * @Author huangjunqiao
 * @Date 2022/01/19 15:09
 * @Description 684. 冗余连接
 */
public class FindRedundentConnection {
    public int[] findRedundantConnection(int[][] edges) {
        // 并查集，时间：O(nlogn)，空间：O(n)
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int p1 = edge[0], p2 = edge[1];
            if (parent[find(parent, p1)] == parent[find(parent, p2)]) {
                return edge;
            } else {
                union(parent, p1, p2);
            }
        }
        return null;
    }
    public void union(int[] parent, int p1, int p2) {
        parent[find(parent, p1)] = parent[find(parent, p2)];
    }
    public int find(int[] parent, int p) {
        if (parent[p] != p) {
            parent[p] = find(parent, parent[p]);// 路径压缩
        }
        return parent[p];
    }
}
