package random.grammar2;

/*
@Author: Toyz
@Date: 2019/9/10
@Time: 16:56
@Purpose:直接常量
@Related:
*/


public class MyTest1 {
    public static void main(String[] args) {
        MyTest1 myTest1 = new MyTest1();
        double i1 = 3.4D;
        Object obj1 = i1;
        if (obj1 instanceof Integer){
            System.out.println("Integer");
        }
        if (obj1 instanceof Double){
            System.out.println("Double");
        }
    }
}
