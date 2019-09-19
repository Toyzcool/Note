package ClassLoader;

/*
@Author: Toyz
@Date: 2019-08-23
@Time: 09:58
*/


public class TestLoader {
    public static void main(String[] args) throws Exception {
        // 由根加载器加载的类
        Class<?> class1 = Class.forName("java.lang.String");
        System.out.println(class1.getClassLoader());

        // 由系统类加载器加载的类
        Class<?> cClass = Class.forName("ClassLoader.C");
        System.out.println(cClass.getClassLoader());
    }
}
class C{ }
