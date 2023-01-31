package haiwaitu.t20220331;

/**
 * @Author huangjunqiao
 * @Date 2022/03/31 23:54
 * @Description 1310. 子数组异或查询
 */
public class XorQueries {
    public int[] xorQueries(int[] arr, int[][] queries) {
        // 前缀异或，时间：O(n)，空间：O(n)
        int n = arr.length;
        int[] res = new int[queries.length];
        int[] prefix = new int[n + 1];
        for (int i = 0 ; i < n; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            res[i] = prefix[l] ^ prefix[r + 1];
        }
        return res;
    }
}
