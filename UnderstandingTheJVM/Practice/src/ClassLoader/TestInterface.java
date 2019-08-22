package ClassLoader;

/*
@Author: Toyz
@Date: 2019-08-22
@Time: 10:06
*/


public class TestInterface {
    public static void main(String[] args) {
        System.out.println(Sub.b);
    }
}
interface Super{
    int a = 5;
}
interface Sub extends Super{
    int b =6;
}
