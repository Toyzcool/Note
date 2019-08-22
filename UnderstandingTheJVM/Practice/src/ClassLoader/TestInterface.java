package ClassLoader;

/*
@Author: Toyz
@Date: 2019-08-22
@Time: 10:06
*/


import java.util.UUID;

public class TestInterface {
    public static void main(String[] args) {
        System.out.println(Sub.a);
    }
}
interface Super{
    String a = "ABC";
    Thread THREAD = new Thread(){
        {
            System.out.println("Super 线程初始化");
        }
    };
}
interface Sub extends Super{
    Thread THREAD = new Thread(){
        {
            System.out.println("Sub 线程初始化");
        }
    };
}
