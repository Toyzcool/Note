package ClassLoader;

/*
@Author: Toyz
@Date: 2019-08-21
@Time: 16:10
*/


public class TestClassLoader {
    public static void main(String[] args) {
        System.out.println("-----Child.str1-----");
        System.out.println(Child.str1);
        // System.out.println("-----Child.str2-----");
        // System.out.println(Child.str2);
    }

}

class Parent{
    static String str1 = "hello world";
    static {
        System.out.println("Parent static block");
    }
}

class Child extends Parent{
    static String str2 = "welcome";
    static {
        System.out.println("Child static block");
    }
}

