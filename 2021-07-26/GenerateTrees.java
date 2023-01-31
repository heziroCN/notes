package haiwaitu.t20210726;

import haiwaitu.TreeNode;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/07/27 03:55
 * @Description 95. 不同的二叉搜索树 II
 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        // 回溯，生成一颗BST的时间复杂度O(n)，可行BST的个数等价于数学的第n个卡特兰数，用Gn表示，即O(nGn)，Gn=(4^n)/n^(3/2)，空间复杂度为O(nGn)
        return generateTrees(1, n);
    }
    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lTrees = generateTrees(start, i - 1);
            List<TreeNode> rTrees = generateTrees(i + 1, end);
            for (TreeNode l : lTrees) {
                for (TreeNode r : rTrees) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    allTrees.add(node);
                }
            }
        }
        return allTrees;
    }
}
