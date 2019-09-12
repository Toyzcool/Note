package random.extend4;

/*
@Author: Toyz
@Date: 2019/9/12
@Time: 13:37
@Purpose:初始化引用的各种方式1.在定义对象时初始化引用 2.在类的构造器中初始化引用 3.需要使用对象时，才初始化引用 4.使用实例初始化
@Related:
*/


public class MyTest1 {
    Sub sub;
    // 1.在定义对象时初始化引用
    Sub sub1 = new Sub("1.在定义对象时初始化引用");

    // 2.在类的构造器中初始化引用
    public MyTest1() {
        Sub sub2 = new Sub("2.在类的构造器中初始化引用");
    }

    // 4.使用实例初始化
    {
        sub = new Sub("4.使用实例初始化");
    }


    public static void main(String[] args) {
        // 3.需要使用对象时，才初始化引用
        MyTest1 myTest1 = new MyTest1();
        myTest1.sub = new Sub("3.需要使用对象时，才初始化引用");
    }
}

class Sub{
    String s;
    public Sub(String s) {
        System.out.println(s);
    }

}
