package ByteCode;

/*
@Author: Toyz
@Date: 2019/9/8
@Time: 10:56
@Purpose:
@Related:
*/


public class MyTest5 {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();

        apple.test();
        orange.test();
    }
}

class Fruit{
    public void test(){
        System.out.println("Fruit");
    }
}
class Apple extends Fruit{
    @Override
    public void test(){
        System.out.println("Apple");
    }
}
class Orange extends Fruit{
    @Override
    public void test(){
        System.out.println("Orange");
    }
}
