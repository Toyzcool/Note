package Nine.TestWeakHashMap;

/*
@Author: Toyz
@Date: 2019-08-12
@Time: 09:36
*/


import java.util.Map;
import java.util.WeakHashMap;

public class TestWeakHashMap {
    public static void main(String[] args) {
        String s1 = new String("1");
        String s2 = new String("2");
        // 初始化WeakHashMap
        WeakHashMap<String,Person> weakHashMap = new WeakHashMap<>();
        weakHashMap.put(s1, new Person("A"));
        weakHashMap.put(s2, new Person("B"));
        for (Map.Entry<String,Person>  person: weakHashMap.entrySet()) {
            System.out.println(person);
        }
        // 清除键
        s2 = null;
        // 调用垃圾回收器
        System.gc();

        for (Map.Entry<String,Person>  person: weakHashMap.entrySet()) {
            System.out.println(person);
        }
    }
}
