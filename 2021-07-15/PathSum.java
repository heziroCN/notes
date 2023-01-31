package haiwaitu.t20210715;

import haiwaitu.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangjunqiao
 * @Date 2021/07/16 18:42
 * @Description 437. 路径总和 III
 */
public class PathSum {
    // 暴力递归，使用数组存储当前路径节点值。时间：每次遍历数组O(N)，平均递归logN次，
     // 平均O(NlogN)，最坏时间复杂度O(N^2)，空间：数组和递归栈最多都是O(N)
     public int pathSum(TreeNode root, int sum) {
         return pathSum(root, sum, new int[1000], 0);
     }

     public int pathSum(TreeNode root, int sum, int[] array/*保存路径*/, int p/*指向路径终点*/) {
         if (root == null) {
             return 0;
         }
         int tmp = root.val;
         int n = root.val == sum ? 1 : 0;
         for (int i = p - 1; i >= 0; i--) {
             tmp += array[i];
             if (tmp == sum) {
                 n++;
             }
         }
         array[p] = root.val;
         int n1 = pathSum(root.left, sum, array, p + 1);
         int n2 = pathSum(root.right, sum, array, p + 1);
         return n + n1 + n2;
     }

    Map<Integer, Integer> map = new HashMap<>();
    public int pathSum0(TreeNode root, int sum) {
        // 前缀和，时间：每个节点访问一次，O(N)，空间：递归栈和哈希表大小最多为N，O(N)
        // 前缀和类问题需要注意，前缀如包含第一个元素（这里是根节点），需要初始化
        map.put(0, 1);
        return sumCore(root, sum, 0);
    }
    public int sumCore(TreeNode node, int target, int currSum) {
        if (node == null) {
            return 0;
        }
        currSum += node.val;
        // 1、获取当前路径符合结果的子路径数量（易错点：这一步和第2步不可以互换，否则target为0时result会多1）
        int result = map.getOrDefault(currSum - target, 0);
        // 2、用当前的总和currSum更新哈希表
        map.put(currSum, 1 + map.getOrDefault(currSum, 0));

        result += sumCore(node.left, target, currSum);
        result += sumCore(node.right, target, currSum);

        map.put(currSum, map.get(currSum) - 1);
        return result;
    }
}
