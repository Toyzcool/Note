package ten;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list2.add(2);
        list2.add(1);
        list2.add(3);
        System.out.println(list1.equals(list2));
    }
}
