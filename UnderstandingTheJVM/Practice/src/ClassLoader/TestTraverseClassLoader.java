package ClassLoader;

/*
@Author: Toyz
@Date: 2019-08-23
@Time: 13:28
*/


public class TestTraverseClassLoader {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        while (null != classLoader){
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }
    }
}
