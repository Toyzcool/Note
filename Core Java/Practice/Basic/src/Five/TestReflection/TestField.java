package Five.TestReflection;

import java.lang.reflect.Field;

public class TestField {
    public static void main(String[] args) throws Exception {
        /*
        getField和getDeclaredField
         */
        // getField
        System.out.println("--测试getField");
        Field[] field1 = Son.class.getFields();
        for (Field f : field1) {
            System.out.println(f);
        }
        // getDeclaredField
        System.out.println("--测试getDeclaredField");
        Field[] field2 = Son.class.getDeclaredFields();
        for (Field f : field2) {
            System.out.println(f);
        }
        /*
        get和set方法
         */
        Son son = new Son();
        // get,public
        System.out.println("--测试get方法，使用getField,作用于public修饰对象");
        Field field3 = Son.class.getField("pubSonName");
        Object value3 = field3.get(son);
        System.out.println(value3);
        // get,private
        System.out.println("--测试get方法，使用getField,作用于private修饰对象");
            // 由于getField只能作用于public修饰的成员，因此无法访问
            // Field field4 = Son.class.getField("priSonName");
            // field4.setAccessible(true);
            // Object value4 = field4.get(son);
            // System.out.println(value4);
        System.out.println("失败");
        // get,private
        System.out.println("--测试get方法，使用getDeclaredField,作用于private修饰对象");
        Field field5 = Son.class.getDeclaredField("priSonName");
        field5.setAccessible(true);
        Object value5 = field5.get(son);
        System.out.println(value5);
        // set,public
        System.out.println("--测试set方法，使用getField,作用于public修饰对象");
        Field field6 = Son.class.getField("pubSonName");
        field6.set(son, "Toyz");
        Object value6 = field6.get(son);
        System.out.println(value6);
        // set,private
        System.out.println("--测试set方法，使用getDeclaredField,作用于private修饰对象");
        Field field7 = Son.class.getDeclaredField("priSonName");
            // 获取前需要忽略访问的安全检查
            field7.setAccessible(true);
        Object value7 = field7.get(son);
        System.out.println("修改前，priSonName:"+value7);
        field7.set(son, "QQ");
        value7 = field7.get(son);
        System.out.println("修改前，priSonName:"+value7);

    }
}
