package haiwaitu.t20211117;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangjunqiao
 * @Date 2021/11/18 11:20
 * @Description 391. 完美矩形
 */
public class IsRectangleCover {
    public boolean isRectangleCover(int[][] rectangles) {
        // 时间：O(N)，空间：O(N)
        int minX = rectangles[0][0], minY = rectangles[0][1], maxX = rectangles[0][2], maxY = rectangles[0][3];
        long area = 0;
        Map<Point, Integer> map = new HashMap<>();
        for (int[] rectan : rectangles) {
            int x = rectan[0], y = rectan[1], a = rectan[2], b = rectan[3];

            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxX = Math.max(maxX, a);
            maxY = Math.max(maxY, b);

            area += (long) (a - x) * (b - y);

            Point p1 = new Point(x, y);
            Point p2 = new Point(x, b);
            Point p3 = new Point(a, y);
            Point p4 = new Point(a, b);
            map.put(p1, map.getOrDefault(p1, 0) + 1);
            map.put(p2, map.getOrDefault(p2, 0) + 1);
            map.put(p3, map.getOrDefault(p3, 0) + 1);
            map.put(p4, map.getOrDefault(p4, 0) + 1);
        }

        Point minMin = new Point(minX, minY);
        Point minMax = new Point(minX, maxY);
        Point maxMin = new Point(maxX, minY);
        Point maxMax = new Point(maxX, maxY);
        if (area != (long) (maxX - minX) * (maxY - minY) || map.getOrDefault(minMin, 0) != 1 || map.getOrDefault(minMax, 0) != 1 || map.getOrDefault(maxMin, 0) != 1 || map.getOrDefault(maxMax, 0) != 1) {// 面积必须相等；4个顶点出现次数只能为1次
            return false;
        }
        map.remove(minMin);
        map.remove(minMax);
        map.remove(maxMin);
        map.remove(maxMax);
        for (Map.Entry<Point, Integer> entry : map.entrySet()) {// 顶点之外的点只能出现2次或4次
            if (entry.getValue() != 2 && entry.getValue() != 4) {
                return false;
            }
        }
        return true;
    }

    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int hashCode() {
            return x + y;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Point) {
                Point p = (Point) o;
                return p.x == this.x && p.y == this.y;
            }
            return false;
        }
    }
}
