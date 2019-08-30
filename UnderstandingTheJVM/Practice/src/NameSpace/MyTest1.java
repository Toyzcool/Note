package NameSpace;

/*
@Author: Toyz
@Date: 2019/8/30
@Time: 07:40
@Purpose:不同加载器加载同一个类的比较
@Related:none
*/


import ClassUnloading.CustomLoader;

import java.lang.reflect.Method;

public class MyTest1 {
    public static void main(String[] args) throws Exception {
        // CustomLoader loader1 = new CustomLoader("loader1");
        // CustomLoader loader2 = new CustomLoader("loader2");
        // Class<?> clazz1 = loader1.loadClass("NameSpace.Person");
        // Class<?> clazz2 = loader2.loadClass("NameSpace.Person");
        // // 比较由加载器加载返回的Class对象是否相同
        // System.out.println("clazz1 == clazz2："+ (clazz1 == clazz2)); //由系统加载器加载，在同一个命名空间中
        // System.out.println("clazz1的加载器："+clazz1.getClassLoader());
        // System.out.println("clazz2的加载器："+clazz2.getClassLoader());
        // System.out.println("===================");
        //
        // // 比较由反射创建的类的实例并调用方法
        // Object object1 = clazz1.getDeclaredConstructor().newInstance();
        // Object object2 = clazz2.getDeclaredConstructor().newInstance();
        // Method method = clazz1.getMethod("setPerson",Object.class);
        // method.invoke(object1, object2); //在object1对象上调用方法，传入的参数为object2


        CustomLoader loader1 = new CustomLoader("loader1");
        loader1.setPath("/Users/space/Documents/Growth/Package/Note/UnderstandingTheJVM/Practice/createClass/");
        CustomLoader loader2 = new CustomLoader("loader2");
        loader2.setPath("/Users/space/Documents/Growth/Package/Note/UnderstandingTheJVM/Practice/createClass/");
        Class<?> clazz1 = loader1.loadClass("NameSpace.Person");
        Class<?> clazz2 = loader2.loadClass("NameSpace.Person");
        // 比较由加载器加载返回的Class对象是否相同
        System.out.println("clazz1 == clazz2："+ (clazz1 == clazz2)); //由系统加载器加载，在同一个命名空间中
        System.out.println("clazz1的加载器："+clazz1.getClassLoader());
        System.out.println("clazz2的加载器："+clazz2.getClassLoader());
        System.out.println("===================");

        // 比较由反射创建的类的实例并调用方法
        Object object1 = clazz1.getDeclaredConstructor().newInstance();
        Object object2 = clazz2.getDeclaredConstructor().newInstance();
        Method method = clazz1.getMethod("setPerson",Object.class);
        method.invoke(object1, object2); //在object1对象上调用方法，传入的参数为object2
    }
}

class Person{
    Person person;
    // 设置Person变量的值
    public void setPerson(Object object){
        this.person = (Person) object;
    }
}
