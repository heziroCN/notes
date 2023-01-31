package haiwaitu.t20210904;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/09/04 23:13
 * @Description 218. 天际线问题
 */
public class GetSkyline {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // 扫描线+堆，时间：O(NlogN)，空间：O(N)。N为建筑数量
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);//存储建筑右边界和高度
        List<Integer> boundaries = new ArrayList<>();//顺序存储建筑的左右边界
        for (int[] building : buildings) {
            boundaries.add(building[0]);
            boundaries.add(building[1]);
        }
        List<List<Integer>> res = new ArrayList<>();
        Collections.sort(boundaries);
        int idx = 0, len = buildings.length;
        for (int boundary : boundaries) {
            // 1、枚举边界过程中，把”包含“当前边界的建筑存进队列
            while (idx < len && buildings[idx][0] <= boundary) {
                pq.offer(new int[]{buildings[idx][1], buildings[idx][2]});
                idx++;
            }
            // 2、延迟删除，把堆顶已经不包含当前边界的建筑弹出队列
            while (!pq.isEmpty() && pq.peek()[0] <= boundary) {
                pq.poll();
            }
            // 3、统计最大值
            int max = pq.isEmpty() ? 0 : pq.peek()[1];
            if (res.size() == 0 ||  max != res.get(res.size() - 1).get(1)) {// 合并重复高度的点
                res.add(Arrays.asList(boundary, max));
            }
        }
        return res;
    }
}
