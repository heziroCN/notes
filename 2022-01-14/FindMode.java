package haiwaitu.t20220114;

import haiwaitu.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2022/01/15 13:11
 * @Description 501. 二叉搜索树中的众数
 */
public class FindMode {
    int curr;
    int max, cnt;
    List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        // dfs，时间：O(n)，空间：O(n)
        dfs(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        update(node.val);
        dfs(node.right);
    }
    public void update(int val) {
        if (val == curr) {
            cnt++;
        } else {
            cnt = 1;
            curr = val;
        }
        if (cnt == max) {
            list.add(val);
        } else if (cnt > max) {
            max = cnt;
            list.clear();
            list.add(val);
        }
    }

     TreeNode pre = null;
      public int[] findMode0(TreeNode root) {
          // Morris遍历，时间：O(n)，空间：O(1)
          while (root != null) {
              if (root.left == null) {
                  update(root.val);
                  root = root.right;
              } else {
                  pre = root.left;
                  while (pre.right != null && pre.right != root) {
                      pre = pre.right;
                  }
                  if (pre.right == null) {
                      pre.right = root;
                      root = root.left;
                  } else {
                      update(root.val);
                      pre.right = null;
                      root = root.right;
                  }
              }
          }
          int[] res = new int[list.size()];
          for (int i = 0; i < list.size(); i++) {
              res[i] = list.get(i);
          }
          return res;
      }
}
