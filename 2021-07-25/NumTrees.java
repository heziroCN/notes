package haiwaitu.t20210725;

/**
 * @Author huangjunqiao
 * @Date 2021/07/26 17:28
 * @Description 96. 不同的二叉搜索树
 */
public class NumTrees {
    public int numTrees(int n) {
        // DP解法，时间O(N^2)，空间O(N)
        // G(n)表示n个节点可以构成的BST数，由于每个节点都可以作为根节点，当以i节点作为根节点时，
        // 可以构成的BST数量为：左子树数量*右子树数量，即G(i-1)*G(n-i)，表示为F(i,n)，
        // 则结果为F(1,n)+F(2,n)+...+F(n,n)
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
