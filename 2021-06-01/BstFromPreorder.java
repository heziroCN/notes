package haiwaitu.t20210601;

import haiwaitu.TreeNode;

import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/06/02 18:16
 * @Description 1008. 前序遍历构造二叉搜索树
 */
public class BstFromPreorder {
     public TreeNode bstFromPreorder(int[] preorder) {
         // 递归构建+二分，时间O(NlogN)，空间O(N)
         return bstCore(preorder, 0, preorder.length - 1);
     }
     public TreeNode bstCore(int[] preorder, int currIdx, int r) {
         if (currIdx > r) {
             return null;
         }
         int val = preorder[currIdx];
         TreeNode currNode = new TreeNode(val);
         if (currIdx == r) {
             return currNode;
         }
         int l = currIdx;
         int right = r;
         // 二分搜索，找到左右子树的分界点
         while (l < right) {
             int mid = (1 + l + right) >> 1;
             if (preorder[mid] < val) {
                 l = mid;
             } else {
                 right = mid - 1;
             }
         }
         // [currIdx+1,l]为左子树节点，右子树节点[l+1, r]
         currNode.left = bstCore(preorder, currIdx + 1, l);
         currNode.right = bstCore(preorder, l + 1, r);
         return currNode;
     }

     int index;
     public TreeNode bstFromPreorder1(int[] preorder) {
         // 数值上下界递归，时间O(N)，空间O(N)
         return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
     }
     public TreeNode dfs(int[] preorder, int lowerBound, int upperBound) {
         if (index == preorder.length)
             return null;
         int val = preorder[index];
         if (val < lowerBound || val > upperBound) {
             return null;
         }

         index++;
         TreeNode node = new TreeNode(val);
         node.left = dfs(preorder, lowerBound, val);
         node.right = dfs(preorder, val, upperBound);
         return node;
     }

    public TreeNode bstFromPreorder2(int[] preorder) {
        // 数值上下界的迭代解法，时间O(N)，空间O(N)
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            int val = preorder[i];
            TreeNode currNode = new TreeNode(val);
            TreeNode node = stack.peek();
            // 按照BST和前序遍历的特性，若栈顶元素比当前节点小，说明当前节点currNode为栈顶的右子节点或祖先的右子节点，所以这里找到“刚好小于”currNode的栈顶元素node
            while (!stack.isEmpty() && stack.peek().val < currNode.val) {
                node = stack.pop();
            }
            if (node.val > currNode.val) {
                node.left = currNode;
            } else {
                node.right = currNode;
            }
            stack.push(currNode);
        }
        return root;
    }
}
