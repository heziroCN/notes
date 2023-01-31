package haiwaitu.t20210421;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

/**
 * @Author huangjunqiao
 * @Date 2021/04/21 15:46
 * @Description 使用递归及非递归两种方式实现快速排序
 */
public class QuickSort {
    public static Random rand = new Random();

    public int[] quickSort(int[] nums) {
        // 递归快排，时间O(NlogN)，空间O(logN)
        if (nums == null || nums.length == 0) {
            return null;
        }
        qSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void qSort(int[] nums, int start, int end) {
        // 子数组只剩下一个元素时，终止递归
        if (start >= end) {
            return;
        }
        int bound = partition(nums, start, end);
        if (bound > start) {
            qSort(nums, start, bound - 1);
        }
        if (bound < end) {
            qSort(nums, bound + 1, end);
        }
    }

    public int partition(int[] nums, int start, int end) {
        // 随机取一个数作为分界线，放置到子数组末尾，方便遍历的时候交换元素
        int idx = rand.nextInt(end - start) + start;
        swap(nums, idx, end);
        int j = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                swap(nums, i, j);
                j++;
            }
        }
        swap(nums, j, end);

        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public int[] sortArray(int[] nums) {
        // 迭代快排，时间O(NlogN)，空间O(logN)
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        stack.push(nums.length - 1);
        while (!stack.isEmpty()) {
            int end = stack.pop();// 先弹出来的是右边界
            int start = stack.pop();
            if (start == end) {
                continue;
            }
            int pivot = partition(nums, start, end);
            if (pivot > start) {
                stack.push(start);
                stack.push(pivot - 1);
            }
            if (pivot < end) {
                stack.push(pivot + 1);
                stack.push(end);
            }
        }
        return nums;
    }

}
