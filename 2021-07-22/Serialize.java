package haiwaitu.t20210722;

import haiwaitu.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2021/07/23 17:27
 * @Description 297. 二叉树的序列化与反序列化
 */

public class Serialize {
     public String serialize(TreeNode root) {
         // 先序遍历递归，用"n"表示空树，时间O(N)，空间O(N)
         StringBuilder sb = new StringBuilder();
         dfs(root, sb);
         return sb.toString();
     }
     public void dfs(TreeNode node, StringBuilder sb) {
         if (node == null) {
             sb.append("n").append(",");
             return;
         }
         sb.append(node.val).append(",");
         dfs(node.left, sb);
         dfs(node.right, sb);
     }

     public TreeNode deserialize(String data) {
         String[] nodes = data.split(",");
         List<String> nodeList = new LinkedList<>(Arrays.asList(nodes));
         return buildCore(nodeList);
     }
     public TreeNode buildCore(List<String> nodeList) {
         if (nodeList.get(0).equals("n")) {
             nodeList.remove(0);
             return null;
         }
         TreeNode node = new TreeNode(Integer.valueOf(nodeList.get(0)));
         nodeList.remove(0);
         node.left = buildCore(nodeList);
         node.right = buildCore(nodeList);
         return node;
     }

    public String serialize0(TreeNode root) {
        // 中序遍历递归，每个子树都用()分割，"X"表示空树，时间O(N)，空间O(N)
        if (root == null) {
            return "X";
        }
        String leftStr = "(" + serialize0(root.left) +")";
        String rightStr = "(" + serialize0(root.right) +")";
        return  leftStr + root.val + rightStr;
    }
    public TreeNode deserialize0(String data) {
        // 使用长度为1的数组存储字符串指针，指向当前处理的字符
        int[] ptr = {0};
        return parse(data, ptr);
    }
    public TreeNode parse(String data, int[] ptr) {
        if (data.charAt(ptr[0]) == 'X') {
            ptr[0]++;
            return null;
        }
        TreeNode node = new TreeNode(0);
        node.left = parseSubtree(data, ptr);
        node.val = parseNum(data, ptr);
        node.right = parseSubtree(data, ptr);
        return node;
    }
    public TreeNode parseSubtree(String data, int[] ptr) {
        ptr[0]++; // 跳过左括号
        TreeNode node = parse(data, ptr); // 递归处理子树
        ptr[0]++; // 跳过右括号
        return node;
    }
    public int parseNum(String data, int[] ptr) {
        int sgn = 1;
        // 第一个字符不是数字，说明是负数，跳过符号并反转符号
        if (!Character.isDigit(data.charAt(ptr[0]))) {
            sgn = -1;
            ptr[0]++;
        }
        int num = 0;
        while (Character.isDigit(data.charAt(ptr[0]))) {
            num = num * 10 + data.charAt(ptr[0]) - '0';
            ptr[0]++;
        }
        return sgn * num;
    }
}

