package haiwaitu.t20210512;

/**
 * @Author huangjunqiao
 * @Date 2021/05/13 10:51
 * @Description 905. 按奇偶排序数组
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        // 两边扫描+原地 时间O(N)，空间O(1)
        int oddIdx = 0;
        int evenIdx = A.length - 1;
        while (evenIdx >= oddIdx) {
            // 不是偶数则继续向前寻找
            if (A[evenIdx] % 2 == 1) {
                evenIdx--;
                continue;
            }
            // 不是奇数则继续向后寻找
            if (A[oddIdx] % 2 == 0) {
                oddIdx++;
                continue;
            }
            swap(A, oddIdx, evenIdx);
        }
        return A;
        // 排序算法 时间O(NlogN)，空间O(N)
        // Integer[] B = new Integer[A.length];
        // for (int t = 0; t < A.length; ++t)
        //     B[t] = A[t];

        // Arrays.sort(B, (a, b) -> Integer.compare(a%2, b%2));

        // for (int t = 0; t < A.length; ++t)
        //     A[t] = B[t];
        // return A;
    }
    public void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}
