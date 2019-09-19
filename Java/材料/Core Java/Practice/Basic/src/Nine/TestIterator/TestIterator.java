package Nine.TestIterator;

/*
@Author: Toyz
@Date: 2019-08-12
@Time: 14:11
*/


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TestIterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        // 迭代器实现遍历
        ListIterator listIterator = list.listIterator();
        listIterator.add("D");

        // 迭代器实现遍历
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        // for-each实现遍历
        for (String s : list) {
            System.out.println(s);
        }
    }
}
