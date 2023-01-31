package haiwaitu.t20220331;

/**
 * @Author huangjunqiao
 * @Date 2022/04/01 00:31
 * @Description 1734. 解码异或后的排列
 */
public class Decode {
    public int[] decode(int[] encoded) {
        // 异或恒等律、异或归零律的运用，时间：O(n)，空间：O(1)
        int n = encoded.length + 1;
        int total = 0, odd = 0;
        for (int i = 1; i <= n; i++) {
            total ^= i;
        }
        for (int i = 1; i < n - 1; i += 2) {
            odd ^= encoded[i];
        }
        int[] perm = new int[n];
        perm[0] = total ^ odd;
        for (int i = 1; i < n; i++) {
            perm[i] = perm[i - 1] ^ encoded[i - 1];
        }
        return perm;
    }
}
