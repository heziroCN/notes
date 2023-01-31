package haiwaitu.t20220109;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2022/01/10 15:14
 * @Description 975. 奇偶跳
 */
public class OddEvenJump {
    public int oddEvenJumps(int[] arr) {
        // 排序+单调栈+dp，时间：O(nlogn)，空间：O(n)
        int n = arr.length;
        Integer[] A = new Integer[n];
        for (int i = 0; i < n; i++) {
            A[i] = i;
        }
        Arrays.sort(A, (i, j) -> arr[i] == arr[j] ? i - j : arr[i] - arr[j]);
        int[] oddNext = markNext(n, A);
        Arrays.sort(A, (i, j) -> arr[i] == arr[j] ? i - j : arr[j] - arr[i]);
        int[] evenNext = markNext(n, A);

        int[][] dp = new int[n][2];// dp[i][0],dp[i][1]为1表示第i次跳为奇数、偶数跳时能否到达末尾的表示
        dp[n - 1][0] = 1;
        dp[n - 1][1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (oddNext[i] != -1 && dp[oddNext[i]][1] == 1) {
                dp[i][0] = 1;
            }
            if (evenNext[i] != -1 && dp[evenNext[i]][0] == 1) {
                dp[i][1] = 1;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i][0] == 1) {
                res++;
            }
        }
        return res;
    }
    public int[] markNext(int n, Integer[] A) {
        Deque<Integer> stk = new LinkedList<>();
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && A[i] > stk.peek()) {
                res[stk.pop()] = A[i];
            }
            stk.push(A[i]);
        }
        return res;
    }

    public int oddEvenJumps0(int[] arr) {
        // 红黑树+dp，时间：O(nlogn)，空间：O(n)
        int n = arr.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);
        boolean[] odd = new boolean[n], even = new boolean[n];
        odd[n - 1] = true;
        even[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            Integer bigger = map.ceilingKey(arr[i]);
            Integer smaller = map.floorKey(arr[i]);
            if (bigger != null && even[map.get(bigger)]) {
                odd[i] = true;
            }
            if (smaller != null && odd[map.get(smaller)]) {
                even[i] = true;
            }
            map.put(arr[i], i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (odd[i]) {
                res++;
            }
        }
        return res;
    }
}
