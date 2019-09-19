package Nine.TestHashMap;

/*
@Author: Toyz
@Date: 2019-08-12
@Time: 08:16
*/


import java.util.HashMap;
import java.util.Map;

public class TestMerge {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        // C作为键第一次出现
        map.put("C", map.get("C")+1);

        // 解决方法1
        map.put("C", map.getOrDefault("C", 0)+1);

        // 解决方法2
        map.put("C", map.merge("C", 1, Integer::sum));

        System.out.println(map.get("C"));
    }
}
