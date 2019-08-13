package Nine.TestArrayList;

/*
@Author: Toyz
@Date: 2019-08-12
@Time: 14:45
*/


import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        // set
        list.set(2, "D");

        // get
        String s1 = list.get(2);

        // add
        list.add(3, "E");

        // remove
        list.remove(2);

        for (String s : list) {
            System.out.println(s);
        }
    }
}
