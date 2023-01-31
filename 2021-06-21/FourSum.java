package haiwaitu.t20210621;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2021/06/22 11:36
 * @Description 18. 四数之和
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 排序+双指针，用两重循环枚举前两个数，用双指针找到另外两个数，时间O(N^3)，空间O(1)，类似题目为15. 三数之和
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        // 为了防止枚举到重复的数：1、下一个指针必须从上一个指针后一个位置开始；2、遇到重复数字只取第一个；3、找到目标组合后，跳过剩余重复的数字
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 剪枝，如果前四个数或者后三个数就不满足target了，可以提前终止或跳出当前循环
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) {
                    continue;
                }
                int l = j + 1, r = len - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum > target) {
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        result.add(buildList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        l++;
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        r--;
                    }
                }
            }
        }
        return result;
    }
    List<Integer> buildList(int num1, int num2, int num3, int num4) {
        List<Integer> list = new ArrayList<>();
        list.add(num1);
        list.add(num2);
        list.add(num3);
        list.add(num4);
        return list;
    }
}
