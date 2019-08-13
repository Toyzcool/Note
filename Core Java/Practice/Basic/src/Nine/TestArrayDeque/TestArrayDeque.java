package Nine.TestArrayDeque;

/*
@Author: Toyz
@Date: 2019-08-13
@Time: 13:50
*/


import java.util.*;

public class TestArrayDeque {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.add("A");
        deque.add("B");
        deque.add("C");
        deque.add("D");

        // peek
        System.out.println(deque.peek());

        // poll
        System.out.println(deque.poll());

        for (String s : deque) {
            System.out.println(s);
        }
    }
}
