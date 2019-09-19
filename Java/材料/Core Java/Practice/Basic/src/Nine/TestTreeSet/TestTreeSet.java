package Nine.TestTreeSet;

import java.util.SortedSet;
import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<String>();
        sortedSet.add("c");
        sortedSet.add("b");
        sortedSet.add("am");
        for (String s : sortedSet) {
            System.out.println(s);
        }
    }
}
