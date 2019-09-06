package LauncherClass;

/*
@Author: Toyz
@Date: 2019/8/30
@Time: 12:23
@Purpose:
@Related:
*/


import ClassUnloading.CustomLoader;

public class MyTest1 {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(ClassLoader.class.getClassLoader());
        System.out.println(System.getProperty("java.class.path"));
        CustomLoader loader = new CustomLoader("loader");
        loader.setPath("/Users/space/Documents/Growth/Package/Note/UnderstandingTheJVM/Practice/src/");
        Class<?> clazz = loader.loadClass("LauncherClass.A");
        System.out.println(clazz.getClassLoader());
    }
}

