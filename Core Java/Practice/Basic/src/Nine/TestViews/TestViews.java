package Nine.TestViews;

/*
@Author: Toyz
@Date: 2019-08-12
@Time: 12:25
*/


import Nine.TestWeakHashMap.Person;

import java.util.Arrays;
import java.util.List;

public class TestViews {
    public static void main(String[] args) {
        Person[] people = new Person[10];
        List<Person> peoples = Arrays.asList(people);
        peoples.set(2, new Person("toyz"));
        System.out.println(peoples.get(2));
    }
}
