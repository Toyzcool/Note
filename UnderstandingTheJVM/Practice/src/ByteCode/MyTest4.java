package ByteCode;

/*
@Author: Toyz
@Date: 2019/9/8
@Time: 10:05
@Purpose:方法重载是静态行为的证明
@Related:
*/


public class MyTest4 {
    public void test(Grandpa grandpa){
        System.out.println("Grandpa");
    }
    public void test(Father father){
        System.out.println("Father");
    }
    public void test(Son son){
        System.out.println("Son");
    }

    public static void main(String[] args) {
        Grandpa p1 = new Father();
        Grandpa p2 = new Son();

        MyTest4 myTest4 = new MyTest4();

        myTest4.test(p1);
        myTest4.test(p2);
    }
}

class Grandpa{}
class Father extends Grandpa{}
class Son extends Father{}
