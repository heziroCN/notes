package haiwaitu.t20211015;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/10/16 15:20
 * @Description 690. 员工的重要性
 */
public class GetImportance {
    Map<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        // dfs，时间：每个员工访问一次，O(N)，空间：递归调用栈为员工“树”结构的高度，最坏情况下垂直结构，O(N)。
        map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(id);
    }
    public int dfs(int id) {
        Employee curr = map.get(id);
        int sum = curr.importance;
        for (Integer subId : curr.subordinates) {
            sum += dfs(subId);
        }
        return sum;
    }
    public int getImportance0(List<Employee> employees, int id) {
        // bfs，时间：O(N)，空间：O(N)
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        int res = 0;
        Deque<Integer> q = new LinkedList<>();
        q.offer(id);
        while (!q.isEmpty()) {
            Employee curr = map.get(q.poll());
            res += curr.importance;
            List<Integer> subIds = curr.subordinates;
            for (Integer subId : subIds) {
                q.offer(subId);
            }
        }
        return res;
    }
}
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};