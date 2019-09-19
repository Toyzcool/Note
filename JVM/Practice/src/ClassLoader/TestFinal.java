package ClassLoader;

/*
@Author: Toyz
@Date: 2019-08-22
@Time: 07:55
*/


import java.util.UUID;

public class TestFinal {
    public static void main(String[] args) {
        // System.out.println(TestBase.s);
        System.out.println(TestBase.sRandom);
    }
}
class TestBase{
    static final String s = "ABC";
    static final String sRandom = UUID.randomUUID().toString();

    static {
        System.out.println("TestBase Build");
    }
}
