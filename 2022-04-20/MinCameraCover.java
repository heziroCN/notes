package haiwaitu.t20220420;

import haiwaitu.TreeNode;

/**
 * @Author huangjunqiao
 * @Date 2022/04/20 01:14
 * @Description 968. 监控二叉树
 */
public class MinCameraCover {
    /**
     * 定义3个状态a,b,c，a：当前节点装摄像头，且监控覆盖到其所有子树，所需的摄像头数
     * b：监控覆盖到当前子树，但当前节点不一定装摄像头，所需的摄像头数
     * c：监控覆盖到左右子树，但不一定覆盖到当前节点，所需的摄像头数
     */
    public int minCameraCover(TreeNode root) {
        // 时间：O(n)，空间：O(n)
        int[] arr = dfs(root);
        return arr[1];
    }
    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] {2, 0, 0};// 不一定是2，保证>=1（叶子节点状态a）即可
        }
        int[] leftArr = dfs(node.left);
        int[] rightArr = dfs(node.right);
        int[] arr = new int[3];
        arr[0] = 1 + leftArr[2] + rightArr[2];
        arr[1] = Math.min(arr[0], Math.min(leftArr[0] + rightArr[1], leftArr[1] + rightArr[0]));
        arr[2] = Math.min(arr[0], leftArr[1] + rightArr[1]);
        return arr;
    }
}
