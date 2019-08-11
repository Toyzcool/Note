package Nine.TestLinkedList;

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
        // 向后越过并删除元素
        listIterator.next(); //必须向后（next）或向前(previous)越过元素后，才能使用remove方法
        listIterator.remove();
        // 向前越过并删除元素
        listIterator.previous(); //必须向后（next）或向前(previous)越过元素后，才能使用remove方法
        listIterator.remove();

        staff.set(0, "G");
        System.out.println(staff.toString());

    }

}
