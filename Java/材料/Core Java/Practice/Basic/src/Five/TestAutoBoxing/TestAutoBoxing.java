package Five.TestAutoBoxing;

import java.util.ArrayList;

public class TestAutoBoxing {
    public static void main(String[] args) {
        // 装箱
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        // 拆箱
        int intType = list.get(0);
        System.out.println(intType);


        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        System.out.println("a == b:"+(a.equals(b)));
        System.out.println("c == d:"+(c.equals(d)));
    }
}
