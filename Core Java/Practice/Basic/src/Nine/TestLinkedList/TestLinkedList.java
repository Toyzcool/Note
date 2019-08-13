package Nine.TestLinkedList;

/*
@Author: Toyz
@Date: 2019-08-13
@Time: 09:27
*/


import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestLinkedList {
    public static void main(String[] args) throws Exception {
        List<String> linkedlist = new LinkedList<>();
        linkedlist.add("A");
        linkedlist.add("B");
        linkedlist.add("C");

        Iterator iterator = linkedlist.listIterator();


        // System.out.println(linkedlist.get(0));
        // add
        linkedlist.add(1, "D");

        // remove
        linkedlist.remove("C");

        // get
        linkedlist.get(2);

        // set
        linkedlist.set(1, "G");

        for (String s : linkedlist) {
            System.out.println(s);
        }
    }

}
