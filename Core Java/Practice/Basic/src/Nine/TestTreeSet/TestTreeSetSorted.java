package Nine.TestTreeSet;

import java.util.SortedSet;
import java.util.TreeSet;

public class TestTreeSetSorted {
    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toy", 123));
        parts.add(new Item("Adam", 321));
        parts.add(new Item("Fake", 63));
        System.out.println(parts);
    }
}
