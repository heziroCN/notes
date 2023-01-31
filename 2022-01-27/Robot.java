package haiwaitu.t20220127;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author huangjunqiao
 * @Date 2022/01/28 06:35
 * @Description LCP 03. 机器人大冒险
 */
public class Robot {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        // 时间：O(x+y)，空间：(n)，n为障碍物数量 用时：24min
        int curr = 0, len = command.length();
        Set<Integer> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            int p = obstacle[0], q = obstacle[1];
            set.add(p * 31 + q);
        }
        int i = 0, j = 0;
        while (i < x || j < y) {
            curr %= len;
            char c = command.charAt(curr++);
            if (c == 'R') {
                i++;
            } else {
                j++;
            }
            if (i == x && j == y) {
                return true;
            } else if (set.contains(i * 31 + j)) {
                return false;
            }
        }
        return false;
    }

    public boolean robot0(String command, int[][] obstacles, int x, int y) {
        // 时间：O(mn)，空间：O(1)，m为指令数量，n为障碍物数量
        int row = 0, col = 0;
        for (char c : command.toCharArray()) {
            if (c == 'R') {
                row++;
            } else {
                col++;
            }
        }
        if (!canReach(command, row, col, x, y)) {
            return false;
        }

        for (int[] obstacle : obstacles) {
            if (obstacle[0] <= x && obstacle[1] <= y
                    && canReach(command, row, col, obstacle[0], obstacle[1])) {
                return false;
            }
        }
        return true;
    }
    public boolean canReach(String command, int row, int col, int x, int y) {
        boolean canReach = false;
        int loop = Math.min(x / row, y / col);
        row *= loop;
        col *= loop;
        for (char c : command.toCharArray()) {
            if (row == x && col == y) {
                return true;
            }
            if (c == 'R') {
                row++;
            } else {
                col++;
            }
        }
        return false;
    }
}
