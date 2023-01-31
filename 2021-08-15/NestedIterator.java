package haiwaitu.t20210815;

import haiwaitu.NestedInteger;

import java.util.*;

/**
 * 类似题目：173. 二叉搜索树迭代器，同样是实现迭代器的三个方法
 *
 * @Author huangjunqiao
 * @Description 341. 扁平化嵌套列表迭代器
 */
public class NestedIterator implements Iterator<Integer> {
    // 时间：初始化和next()方法O(1)，hasNext()平均O(1)，空间：最坏情况下嵌套成一条链，栈需要存储N个元素，O(N)
//    Deque<Iterator<NestedInteger>> stack;
//    public NestedIterator(List<NestedInteger> nestedList) {
//        stack = new LinkedList<>();
//        stack.push(nestedList.iterator());
//    }
//
//    @Override
//    public Integer next() {
//        return stack.peek().next().getInteger();
//    }
//
//    @Override
//    public boolean hasNext() {
//        while (!stack.isEmpty()) {
//            if (!stack.peek().hasNext()) {
//                // 当前子列表已经遍历到末尾，向上一层列表继续搜索
//                stack.pop();
//                continue;
//            }
//            NestedInteger nest = stack.peek().next();
//            if (!nest.isInteger()) {
//                stack.push(nest.getList().iterator());
//                // return true;// 不能这样写，直接使用nest.getList()的迭代器没法处理空集合、嵌套空集合
//            } else {
//                // 当前NestedInteger如果是整数，转换成集合的形式方便迭代
//                List<NestedInteger> list = new ArrayList<>();
//                list.add(nest);
//                stack.push(list.iterator());
//                return true;
//            }
//        }
//        return false;
//    }

    public LinkedList<NestedInteger> stk;
    public NestedIterator(List<NestedInteger> nestedList) {
        stk = new LinkedList<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stk.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stk.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stk.isEmpty()) {
            if (stk.peek().isInteger()) {
                return true;
            } else {
                List<NestedInteger> currList = stk.pop().getList();
                for (int i = currList.size() - 1; i >= 0; i--) {
                    stk.push(currList.get(i));
                }
            }
        }
        return false;
    }
}
