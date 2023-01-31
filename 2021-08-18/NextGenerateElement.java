package haiwaitu.t20210818;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/08/19 12:03
 * @Description 496. 下一个更大元素 I
 */
public class NextGenerateElement {
     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
         // 哈希表暴力，时间O(MN)，空间O(N)，M、N为num1、nums2的大小
         int len1 = nums1.length, len2 = nums2.length;
         Map<Integer, Integer> map = new HashMap<>();
         for (int i = 0; i < len2; i++) {
             map.put(nums2[i], i);
         }
         int[] res = new int[len1];
         Arrays.fill(res, -1);
         for (int i = 0; i< len1; i++) {
             int idx2 = map.get(nums1[i]);
             for (int j = idx2; j < len2; j++) {
                 if (nums2[j] > nums1[i]) {
                     res[i] = nums2[j];
                     break;
                 }
             }
         }
         return res;
     }

    public int[] nextGreaterElement0(int[] nums1, int[] nums2) {
        // 单调栈，找到nums2每个数右边第一个较大的数，存储在哈希表中。时间：O(M+N)，空间：O(N)
        int len1 = nums1.length, len2 = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stk = new LinkedList<>();
        for (int i = 0; i < len2; i++) {
            while (!stk.isEmpty() && stk.peek() < nums2[i]) {
                map.put(stk.pop(), nums2[i]);// 在map存储右边第一个最大数
            }
            stk.push(nums2[i]);
        }
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }

        return res;
    }
}
