package Nine.TestLinkedHashSet;

/*
@Author: Toyz
@Date: 2019-08-12
@Time: 10:51
*/


import Nine.TestWeakHashMap.Person;

import java.util.*;

public class TestLinkedHashSet {
    public static void main(String[] args) {
        /*
        链接散列映射
         */
        // 初始化链接散列映射
        Map<String, Person> person = new LinkedHashMap<>();
        person.put("00-01", new Person("One"));
        person.put("00-03", new Person("Three"));
        person.put("00-02", new Person("Two"));

        //输出
        for (String s : person.keySet()) {
            System.out.println(s);
        }

        /*
        链接散列集
         */
        Set<Person> personSet = new LinkedHashSet<>();
        personSet.add(new Person("Four"));
        personSet.add(new Person("Six"));
        personSet.add(new Person("Five"));

        //输出
        for (Person p : personSet) {
            System.out.println(p);
        }
    }
}
