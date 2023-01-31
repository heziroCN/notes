package haiwaitu.t20210513;


/**
 * @Author huangjunqiao
 * @Date 2021/05/14 11:01
 * @Description 530. 二叉搜索树的最小绝对差
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class GetMinimumDiference {
    int min = Integer.MAX_VALUE;
    int prev = -1;
    public int getMinimumDifference(TreeNode root) {
        // 递归解法，节点只访问一次，时间O(N)；递归栈深度随着遍历增长，空间O(N)
        // 二叉搜索树特性是中序遍历结果是有序的，因此两节点的差最小值
        // 必定是相邻节点，可以缓存相邻节点，这里用一个指针缓存上一个节点
        preOrder(root);
        return min;
    }
    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        // prev为-1代表第一个节点，此时不需要更新最小值
        if (prev == -1) {
            prev = node.val;
        } else {
            // 非第一个节点，计算差值并更新最小值
            min = Math.min(min, node.val - prev);
            prev = node.val;
        }

        preOrder(node.right);
    }

}
