package Nine.TestHashMap;

/*
@Author: Toyz
@Date: 2019-08-11
@Time: 22:11
*/


import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        // 创建散列映射
        Map<String,Employee> staff = new HashMap<>();

        // 添加元素
        staff.put("00-01", new Employee("Toyz1"));
        staff.put("00-04", new Employee("Toyz4"));
        staff.put("00-02", new Employee("Toyz2"));
        staff.put("00-03", new Employee("Toyz3"));

        // 输出所有元素
        System.out.println("----输出所有元素");
        System.out.println(staff.toString());

        // 删除
        System.out.println("----删除");
        staff.remove("00-01");
        System.out.println(staff.toString());

        // 替换
        System.out.println("----替换");
        staff.put("00-02", new Employee("new Toyz"));
        System.out.println(staff.toString());

        // 查询
        System.out.println("----查询");
        System.out.println(staff.get("00-02"));
        System.out.println(staff.get("00-12"));
        
        // 遍历输出并统计数量
        System.out.println("----遍历输出并统计数量");
        for (String n : staff.keySet()) {
            System.out.println(n+":"+staff.get(n));
        }
        System.out.println("元素数量为："+staff.size());
    }
}
