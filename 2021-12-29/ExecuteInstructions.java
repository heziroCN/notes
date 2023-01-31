package haiwaitu.t20211229;

/**
 * @Author huangjunqiao
 * @Date 2021/12/30 01:19
 * @Description 2120. 执行所有后缀指令
 */
public class ExecuteInstructions {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        // 双重循环，时间：O(m^2)，空间：O(1)
        int m = s.length();
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int cnt = m - i;
            int row = startPos[0], col = startPos[1];
            for (int j = i; j < m; j++) {
                char c = s.charAt(j);
                if (c == 'L') {
                    col--;
                } else if (c == 'R') {
                    col++;
                } else if (c == 'U') {
                    row--;
                } else {
                    row++;
                }
                if (row < 0 || row >= n || col < 0 || col >= n) {
                    cnt = j - i;
                    break;
                }
            }
            res[i] = cnt;
        }
        return res;
    }
}
