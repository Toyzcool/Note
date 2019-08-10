package Five.TestReflection;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class TestReflection {
    public static void main(String[] args) throws Exception {
        // 1.加载配置文件
        // 1.1创建pro对象
        Properties properties = new Properties();
        // 1.2加载配置文件，转换为集合
        // 1.2.1获取配置文件路径
        ClassLoader classLoader = TestReflection.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        properties.load(is);

        // 2.获取配置文件中定义的数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        // 3.加载类进内存
        Class cls1 = Class.forName(className);

        // 4.创建对象
        Object object = cls1.getDeclaredConstructor().newInstance();

        // 5.执行方法
        Method method1 = cls1.getMethod(methodName);
        method1.invoke(object);

    }
}
