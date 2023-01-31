package haiwaitu.t20220302;

/**
 * @Author huangjunqiao
 * @Date 2022/03/02 23:00
 * @Description 1791. 找出星型图的中心节点
 */
public class FindCenter {
     public int findCenter(int[][] edges) {
         // 时间：O(n)，空间：O(n)
         int n = edges.length + 1;
         int[] degree = new int[n + 1];
         for (int[] e : edges) {
             degree[e[0]]++;
             degree[e[1]]++;
         }
         for (int i = 1; i <= n; i++) {
             if (degree[i] == n - 1) {
                 return i;
             }
         }
         return 0;
     }

    public int findCenter0(int[][] edges) {
        // 时间：O(1)，空间：O(1)
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}
