package ClassLoader;

/*
@Author: Toyz
@Date: 2019/8/29
@Time: 11:47
@Purpose:测试类
@Related:TestLoader2
*/


public class Super2 {
    public Super2() {
        System.out.println("Super2的加载器:"+Super2.class.getClassLoader());
        new Sub2();
        System.out.println("From Sub2:"+Sub2.class);
    }
}
