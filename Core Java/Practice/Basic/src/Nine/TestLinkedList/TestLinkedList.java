package Nine.TestLinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TestLinkedList {
    public static void main(String[] args) {
        // 初始化
        List<String> staff = new LinkedList<String>();
        staff.add("A");
        staff.add("B");
        staff.add("C");

        /*
        Test next(),previous()
         */
        // 迭代器初始化
        ListIterator listIterator = staff.listIterator();
        listIterator.add("D");
        // 调用next方法
        listIterator.next();
        listIterator.add("E");
        // 删除元素
        // listIterator.next();
        listIterator.remove();
        System.out.println(staff.toString());

    }

}
