package Five.TestReflection;


import java.lang.reflect.Method;

public class TestMethod {
    public static void main(String[] args) throws Exception {
        /*
        getMethod和getDeclaredMethod
        */
        Son son = new Son();
        // getMethod,空参方法
        System.out.println("--测试getMethod,空参方法");
        Method method1 = Son.class.getMethod("eat");
        System.out.println(method1);
        // getMethods,所有方法
        System.out.println("--测试getMethods");
        Method[] method2 = Son.class.getMethods();
        for (Method m : method2) {
            System.out.println(m);
        }
        // getDeclaredMethods，所有方法
        System.out.println("--测试getDeclaredMethods");
        Method[] method3 = Son.class.getDeclaredMethods();
        for (Method m : method3) {
            System.out.println(m);
        }

        /*
        invoke
        */
        // invoke,含参子类public方法
        System.out.println("--测试invoke,含参子类public方法");
        Method method4 = Son.class.getMethod("eat",String.class);
        method4.invoke(son, "Fish");
        // invoke,含参父类public方法
        System.out.println("--测试invoke,含参父类public方法");
        Method method5 = Son.class.getMethod("edu");
        method5.invoke(son);
        // invoke,无参子类private方法
        System.out.println("--测试invoke,无参子类private方法");
        Method method6 = Son.class.getDeclaredMethod("run");
        method6.setAccessible(true);
        method6.invoke(son);

    }


}
