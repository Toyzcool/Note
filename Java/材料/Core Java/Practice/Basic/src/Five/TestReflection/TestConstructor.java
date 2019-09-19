package Five.TestReflection;

import java.lang.reflect.Constructor;

public class TestConstructor {
    public static void main(String[] args) throws Exception {
        /*
        getConstructor和getDeclaredConstructor
         */
        // getConstructor,无参构造器和有参构造器
        System.out.println("--测试getConstructor");
        Constructor constructor1 = Son.class.getConstructor();
        System.out.println("无参构造器:"+constructor1);
        Constructor constructor2 = Son.class.getConstructor(String.class,int.class,String.class,int.class);
        System.out.println("有参构造器:"+constructor2);
        // getConstructors
        System.out.println("--测试getConstructors");
        Constructor[] constructors3 = Son.class.getConstructors();
        for (Constructor c : constructors3) {
            System.out.println(c);
        }
        // getDeclaredConstructor
        System.out.println("--测试getDeclaredConstructor");
        Constructor constructor4 = Son.class.getDeclaredConstructor(String.class,int.class);
        System.out.println(constructor4);
        // getDeclaredConstructors
        System.out.println("--测试getDeclaredConstructors");
        Constructor[] constructor5 = Son.class.getDeclaredConstructors();
        for (Constructor c : constructor5){
            System.out.println(c);
        }

        /*
        newInstance(Object... initargs)
         */
        // newInstance(Object... initargs)无参构造器
        System.out.println("--newInstance(Object... initargs) 无参构造器");
        Constructor constructor6 = Son.class.getConstructor();
        System.out.println(constructor6.newInstance());
        // newInstance(Object... initargs)含参构造器
        System.out.println("--newInstance(Object... initargs) 含参构造器");
        Constructor constructor7 = Son.class.getDeclaredConstructor(String.class,int.class);
        constructor7.setAccessible(true); // 忽略访问的安全检查
        System.out.println(constructor7.newInstance("Toyz",44));
    }
}
