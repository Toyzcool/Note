package Nine.TestUnmodifiableViews;

/*
@Author: Toyz
@Date: 2019-08-12
@Time: 13:00
*/


import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestUnmodifiableViews {
    public static void main(String[] args) {
        List<String> staff = new LinkedList<>();
        staff.add("A");
        staff.add("B");
        List<String> staffList =  Collections.unmodifiableList(staff);
        staffList.set(1, "DD");
    }
}
