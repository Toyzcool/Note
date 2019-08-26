package ClassLoader;

/*
@Author: Toyz
@Date: 2019-08-26
@Time: 09:23
@Purpose:编写自定义加载器
*/


import java.io.*;

public class TestCreateClassLoader extends ClassLoader {
    /*
    Paraments
     */
    // 保存加载器名称
    private String classLoaderName;
    // 设置加载路径
    private String path;
    // 设置文件扩展名
    private final String fileExtension = ".class";

    /*
    Methods
     */
    // 构造方法,默认系统类构造器为父构造器
    public TestCreateClassLoader(String classLoaderName){
        super(); // 调用父构造器的构造方法
        this.classLoaderName = classLoaderName;
    }
    // 构造方法，指定构造器的构造方法
    public TestCreateClassLoader(String classLoaderName,ClassLoader parent){
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    // 设置加载路径的方法
    public void setPath(String path) {
        this.path = path;
    }

    // 读取文件中的字节码数据，并返回字节码数组
    public byte[] loadClassData(String className){
        // 输出流变量
        InputStream is;
        // 保存字节流的数组
        byte[] data = null;
        // 创建一个byte型别数组的缓冲区
        ByteArrayOutputStream baos;

        // 获取文件路径
        className = className.replace(".", "/");

        try {
            // 文件字节输入流
            is = new FileInputStream(new File(this.path+className+fileExtension));
            baos = new ByteArrayOutputStream();

            // 创建变量判断是否结束输出
            int ch;

            // 读取字节流并写入字节数组的缓冲区
            while (-1 != (ch = is.read())){
                baos.write(ch);
            }
            // 将缓冲区中的内容输入到字节数组
            data = baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    // 重写父加载器中的findClass方法
    @Override protected Class<?> findClass(String className) throws ClassNotFoundException {
        // 输出被加载类名和加载器名称
        System.out.println("className:" + className);
        System.out.println("classLoaderName:" + classLoaderName);
        // 获取到class文件中的字节数组
        byte[] data = this.loadClassData(className);
        // 将字节数组转换为字节实例,defineClass是一个本地方法
        return this.defineClass(className, data, 0, data.length);
    }

    /*
    Test
     */
    public static void main(String[] args) throws Exception {
        TestCreateClassLoader loader1 = new TestCreateClassLoader("loader1");
        loader1.setPath("/Users/space/Documents/Growth/Package/Note/UnderstandingTheJVM/Practice/createClass/");
        Class<?> clazz = loader1.loadClass("TestClass1");
        System.out.println("clazz:"+clazz);
        Object obj = clazz.newInstance();
        System.out.println("obj:"+obj);
    }
}

class TestClass1{
    String string = "ABC";
}
