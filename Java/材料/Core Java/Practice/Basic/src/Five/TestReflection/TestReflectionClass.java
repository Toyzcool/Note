package Five.TestReflection;
/*
Class对象获取的三种方式
 */

public class TestReflectionClass {
    public static void main(String[] args) throws Exception {
        /*
        Class对象获取的三种方式
        1.通过Class.forclass("全类名")获取
        2.通过类名.class()获取
        3.通过对象.getClass()方法
        */
        // 1.通过Class.forclass("全类名")获取
        Class cls1 = Class.forName("Five.TestReflection.Person");
        System.out.println(cls1);
        // 2.通过类名.class()获取
        Class cls2 = Father.class;
        System.out.println(cls2);
        // 3.通过对象.getClass()方法
        Father p = new Father();
        Class cls3 = p.getClass();
        System.out.println(cls3);
        // 4.比较三个class引用所指向的是否为同一个Class对象
        System.out.println("比较三个class引用所指向的是否为同一个Class对象");
        System.out.println("cls1 == cls2:"+(cls1 == cls2));
        System.out.println("cls1 == cls2:"+(cls1 == cls3));
    }
}
