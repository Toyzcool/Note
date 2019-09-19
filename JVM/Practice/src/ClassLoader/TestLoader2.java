package ClassLoader;

/*
@Author: Toyz
@Date: 2019/8/28
@Time: 16:16
@Purpose:测试如果在一个类中创建另一个类的实例，则在类的加载时，是否会加载被创建实例的类
@Related:Super2,Sub2
*/



public class TestLoader2 {
    public static void main(String[] args) throws Exception {
        TestCreateClassLoader loader = new TestCreateClassLoader("loader");
        loader.setPath("/Users/space/Documents/Growth/Package/Note/UnderstandingTheJVM/Practice/createClass/");
        Class<?> clazz = loader.loadClass("ClassLoader.Super2");
        Object object = clazz.newInstance();
        // System.out.println(object);
    }
}


