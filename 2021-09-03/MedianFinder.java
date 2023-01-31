package haiwaitu.t20210903;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/09/03 22:59
 * @Description 295. 数据流的中位数
 */
public class MedianFinder {
    // PriorityQueue<Integer> minQue;
    // PriorityQueue<Integer> maxQue;

    // /** initialize your data structure here. */
    // public MedianFinder() {
    //     // 大小堆，时间：插入为O(logN)，获取中位数O(1)，空间O(N)
    //     minQue = new PriorityQueue<>((a, b) -> b - a);
    //     maxQue = new PriorityQueue<>((a, b) -> a - b);
    // }
    // public void addNum(int num) {
    //     // 保持minQue大小和maxQue相等或者多1，如果minQue为空，那么maxQue肯定也是空。
    //     if (minQue.isEmpty() || num <= minQue.peek()) {
    //         minQue.offer(num);
    //         if (minQue.size() > maxQue.size() + 1) {
    //             maxQue.offer(minQue.poll());
    //         }
    //     } else {
    //         maxQue.offer(num);
    //         if (maxQue.size() > minQue.size()) {
    //             minQue.offer(maxQue.poll());
    //         }
    //     }
    // }
    // public double findMedian() {
    //     if (minQue.size() == maxQue.size()) {
    //         return (minQue.peek() + maxQue.peek()) / 2.0;
    //     } else {
    //         return minQue.peek();
    //     }
    // }

    int[] left;// left[0]存左中位数，数组可能存在多个等值的中位数，left[1]表示中位数在其中是第几个
    int[] right;// right[0]存右中位数，数组可能存在多个等值的中位数，right[1]表示中位数在其中是第几个
    TreeMap<Integer, Integer> map = new TreeMap<>();// 红黑树提高插入效率到logN
    int n;
    public MedianFinder() {
        // 有序集合+双指针，时间：插入O(logN)，获取中位数O(1)，空间：O(N)
        left = new int[2];
        right = new int[2];
        map = new TreeMap<>();
        n = 0;
    }
    public void addNum(int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
        if (n == 0) {
            left[0] = right[0] = num;
            left[1] = right[1] = 1;
        } else if ((n & 1) != 0) {// 奇数时，left[0]即right[0]
            if (num < left[0]) {
                decrease(left);
            } else {
                increase(right);
            }
        } else {// 偶数时，left[0]与right[0]不是同一个元素
            if (num > left[0] && num < right[0]) {
                increase(left);
                decrease(right);
            } else if (num >= right[0]) {
                // increase(left);
                System.arraycopy(right, 0, left, 0, 2);
            } else {
                decrease(right);
                System.arraycopy(right, 0, left, 0, 2);
            }
        }
        n++;
    }
    public double findMedian() {
        return (left[0] + right[0]) / 2.0;
    }
    public void decrease(int[] numAndPos) {
        numAndPos[1]--;
        if (numAndPos[1] == 0) {//如果原中位数已经是第一个中位数了，更新中位数
            numAndPos[0] = map.floorKey(numAndPos[0] - 1);
            numAndPos[1] = map.get(numAndPos[0]);
        }
    }
    public void increase(int[] numAndPos) {
        numAndPos[1]++;
        if (numAndPos[1] > map.get(numAndPos[0])) {
            numAndPos[0] = map.ceilingKey(numAndPos[0] + 1);
            numAndPos[1] = 1;
        }
    }
}
