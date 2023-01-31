package haiwaitu.t20220206;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author huangjunqiao
 * @Date 2022/02/06 20:26
 * @Description 6002. 设计位集
 */
public class BitSet {
    Set<Integer> ones = new HashSet<>(), zeros = new HashSet<>();
    int sz;
    public BitSet(int size) {
        for (int i = 0; i < size; i++) {
            zeros.add(i);
        }
        sz = size;
    }

    public void fix(int idx) {
        zeros.remove(idx);
        ones.add(idx);
    }

    public void unfix(int idx) {
        ones.remove(idx);
        zeros.add(idx);
    }

    public void flip() {
        Set<Integer> temp = ones;
        ones = zeros;
        zeros = temp;
    }

    public boolean all() {
        return sz == ones.size();
    }

    public boolean one() {
        return ones.size() > 0;
    }

    public int count() {
        return ones.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sz; i++) {
            if (zeros.contains(i)) {
                sb.append(0);
            } else {
                sb.append(1);
            }
        }
        return sb.toString();
    }
}
