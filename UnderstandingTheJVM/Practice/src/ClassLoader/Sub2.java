package ClassLoader;

/*
@Author: Toyz
@Date: 2019/8/29
@Time: 11:47
@Purpose:测试类
@Related:TestLoader2
*/


public class Sub2 {
    public Sub2() {
        System.out.println("Sub2的加载器:"+Sub2.class.getClassLoader());
        // System.out.println("From Super2:"+Super2.class);
    }
}
