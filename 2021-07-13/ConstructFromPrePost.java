package haiwaitu.t20210713;

import haiwaitu.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangjunqiao
 * @Date 2021/07/14 16:53
 * @Description 889. 根据前序和后序遍历构造二叉树
 */
public class ConstructFromPrePost {
    Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        // 递归解法，时间O(N)，空间O(N)
        int len = pre.length;
        for (int i = 0; i < len; i++) {
            indexMap.put(post[i], i);
        }
        return constructCore(pre, 0, len - 1, post, 0, len - 1);
    }
    public TreeNode constructCore(int[] pre, int preL, int preR, int[] post, int postL, int postR) {
        // 前序遍历数组区间内第一个元素为当前节点，第二个元素为左子树的根节点；
        // 而后序遍历数组区间内最后一个元素为当前节点，左子树根节点位置为左右子树的分界线
        // 不同于其他两种构建方式，需要特别注意边界条件的处理
        if (preL > preR || postL > postR) {
            return null;
        }
        if (preL == preR) {
            return new TreeNode(pre[preL]);
        }
        int lRootVal = pre[preL + 1];
        // 1、找到左子树根节点在post[]中的位置，即post[]中左右子树的分界线
        int lRootIdx = indexMap.get(lRootVal);
        // 2、计算左子树的节点数量leftNum，并根据leftNum得出pre[]中左右子树的分界线
        int leftNum = lRootIdx - postL + 1;

        TreeNode node = new TreeNode(pre[preL]);
        node.left = constructCore(pre, preL + 1, preL + leftNum, post, postL, lRootIdx);
        node.right = constructCore(pre, preL + leftNum + 1, preR, post, lRootIdx + 1, postR - 1);
        return node;
    }
}
