package haiwaitu.t20220301;

/**
 * @Author huangjunqiao
 * @Date 2022/03/02 12:04
 * @Description 261. 以图判树
 */
public class ValidTree {
    public boolean validTree(int n, int[][] edges) {
        // 时间：O(mlogn)，空间：O(n)，m为edges长度。用时：30min
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int p0 = edge[0], p1 = edge[1];
            if (find(p0, parent) != find(p1, parent)) {
                union(p0, p1, parent);
            } else {
                return false;
            }
        }
        int root = 0;
        for (int i = 0; i < n; i++) {
            if (i == parent[i]) {
                root++;
            }
        }
        return root == 1;
    }
    public int find(int p, int[] parent) {
        if (p != parent[p]) {
            parent[p] = find(parent[p], parent);
        }
        return parent[p];
    }
    public void union(int p0, int p1, int[] parent) {
        int root0 = find(p0, parent), root1 = find(p1, parent);
        parent[root0] = root1;
    }
}
