package haiwaitu.t20221211;

/**
 * @Author huangjunqiao
 * @Date 2022/12/11 03:32
 * @Description 6. Z 字形变换
 */
public class Convert {
    // public String convert(String s, int numRows) {
    //     // 二维矩阵模拟，时间：O(rn)，空间：O(rn)，r为给定的行数。
    //     if (numRows < 2) {
    //         return s;
    //     }
    //     int n = s.length();
    //     char[][] arr = new char[numRows][n];
    //     int idx = 0, i = 0, j = 0;
    //     while (idx < n) {
    //         for (; i < numRows && idx < n; i++) {
    //             arr[i][j] = s.charAt(idx++);
    //         }
    //         i -= 2;
    //         j++;
    //         while (idx < n && i > 0) {
    //             arr[i][j] = s.charAt(idx++);
    //             i--;
    //             j++;
    //         }
    //     }
    //     StringBuilder res = new StringBuilder();
    //     for (int row = 0; row < numRows; row++) {
    //         for (int col = 0; col < n; col++) {
    //             if (arr[row][col] != '\0') {
    //                 res.append(arr[row][col]);
    //             }
    //         }
    //     }
    //     return res.toString();
    // }

    // public String convert(String s, int numRows) {
    //     // 压缩二维矩阵，时间：O(n)，空间：O(n)，r为给定的行数。
    //     if (numRows < 2) {
    //         return s;
    //     }
    //     int n = s.length();
    //     StringBuilder[] arr = new StringBuilder[numRows];
    //     for (int i = 0; i < numRows; i++) {
    //         arr[i] = new StringBuilder();
    //     }
    //     int t = numRows * 2 - 2;// r+(r-2)=2r-2 为一个周期
    //     int idx = 0, x = 0;
    //     while (idx < n) {
    //         arr[x].append(s.charAt(idx));
    //         if (idx % t < numRows - 1) {
    //             x++;
    //         } else {
    //             x--;
    //         }
    //         idx++;
    //     }
    //     StringBuilder res = new StringBuilder();
    //     for (StringBuilder sb : arr) {
    //         res.append(sb);
    //     }
    //     return res.toString();
    // }

    // public String convert(String s, int numRows) {
    //     // 使用flag的压缩二维矩阵，时间：O(n)，空间：O(n)
    //     if (numRows < 2) {
    //         return s;
    //     }
    //     StringBuilder[] arr = new StringBuilder[numRows];
    //     int n = s.length();
    //     for (int i = 0; i < numRows; i++) {
    //         arr[i] = new StringBuilder();
    //     }
    //     int i = 0, flag = -1;
    //     for (char c : s.toCharArray()) {
    //         arr[i].append(c);
    //         if (i == 0 || i == numRows - 1) {
    //             flag = -flag;
    //         }
    //         i += flag;
    //     }
    //     StringBuilder res = new StringBuilder();
    //     for (StringBuilder sb : arr) {
    //         res.append(sb);
    //     }
    //     return res.toString();
    // }
    public String convert(String s, int numRows) {
        // Z字变换的周期是2r-2,对于矩阵第一行的字符，对应的idx有 idx%t=0,最后一行的字符，有 idx%t=r-1。
        // 对于其余行，周期内有两个字符。第一个字符满足 idx%t=i，第二个字符满足 idx%t=t-i
        // 直接构造，时间：O(n)，空间：O(1)
        if (numRows < 2) {
            return s;
        }
        int n = s.length();
        int t = numRows * 2 - 2;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += t) {
                // 第一个字符，每行必有
                res.append(s.charAt(j + i));
                // 第二个字符，除了第一行和最后一行都有
                if (i != 0 && i != numRows - 1 && j + t - i < n) {
                    res.append(s.charAt(j + t - i));
                }
            }
        }
        return res.toString();
    }
}
