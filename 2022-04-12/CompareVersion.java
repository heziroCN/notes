package haiwaitu.t20220412;

/**
 * @Author huangjunqiao
 * @Date 2022/04/12 19:08
 * @Description 165. 比较版本号
 */
public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        // 时间：O(m+n)，空间：O(m+n)
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int m = arr1.length, n = arr2.length;
        int i;
        for (i = 0; i < m && i < n; i++) {
            int num1 = Integer.valueOf(arr1[i]), num2 = Integer.valueOf(arr2[i]);
            if (num1 > num2) {
                return 1;
            } else if (num2 > num1) {
                return -1;
            }
        }
        while (i < m) {
            if (Integer.valueOf(arr1[i]) > 0) {
                return 1;
            }
            i++;
        }
        while (i < n) {
            if (Integer.valueOf(arr2[i]) > 0) {
                return -1;
            }
            i++;
        }
        return 0;
    }

    public int compareVersion0(String version1, String version2) {
        // 双指针，时间：O(m+n)，空间：O(1)
        int m = version1.length(), n = version2.length();
        int i = 0, j = 0;
        while (i < m || j < n) {
            int x = 0, y = 0;
            while (i < m && version1.charAt(i) != '.') {
                x = x * 10 + (version1.charAt(i++) - '0');
            }
            i++;
            while (j < n && version2.charAt(j) != '.') {
                y = y * 10 + (version2.charAt(j++) - '0');
            }
            j++;
            if (x > y) {
                return 1;
            } else if (y > x) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersion o = new CompareVersion();
        System.out.println(o.compareVersion("0.1", "1.1"));
    }
}
