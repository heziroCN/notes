package haiwaitu.t20211205;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/12/06 22:11
 * @Description 380. O(1) 时间插入、删除和获取随机元素
 */
public class RandomizedSet {
    // 哈希表+动态数组，交换数组末尾元素实现O(1)删除。时间：O(1)，空间：O(N)
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random rand = new Random();
    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int lastElement = list.get(list.size() - 1);
        int rmIdx = map.get(val);
        list.set(rmIdx, lastElement);
        map.put(lastElement, rmIdx);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
