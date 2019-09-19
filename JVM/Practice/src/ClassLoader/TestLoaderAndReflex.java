package ClassLoader;

/*
@Author: Toyz
@Date: 2019-08-23
@Time: 12:50
*/

class TestClass{
    static {
        System.out.println("TestClass Init");
    }
}

public class TestLoaderAndReflex {
    public static void main(String[] args) throws Exception {
        // 使用ClassLoader的loadClass方法加载类
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> class1 = classLoader.loadClass("ClassLoader.TestClass");
        System.out.println(class1);
        System.out.println("------------");
        Class<?> class2 = Class.forName("ClassLoader.TestClass");
        System.out.println(class2);

    }
}
