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
    // 存储加载器名称
    private String classLoaderName;
    // 存储加载类文件的路径
    private String path;
    // 类文件扩展名
    private final String fileExtension = ".class";

    /*
    Constructor
     */
    // 构造方法一，调用默认的父加载器的构造方法
    public TestCreateClassLoader(String classLoaderName){
        super();
        this.classLoaderName = classLoaderName;
    }
    // 构造方法二，调用指定父加载器的构造方法
    public TestCreateClassLoader(ClassLoader parent,String classLoaderName){
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    /*
    Methods
     */
    // 设置加载类文件的路径
    public void setPath(String path) {
        this.path = path;
    }

    // 读取字节流，并返回字节数组
    public byte[] loadClassData(String className) {
        // 获取文件输入流
        InputStream is = null;
        // 存储字节数组
        byte[] data = null;
        // 字节流缓冲区
        ByteArrayOutputStream baos = null;
        // 修改存储路径
        className = className.replace(".", "/");

        try {
            // 获取文件输入流
            is = new FileInputStream(new File(this.path+className+this.fileExtension));
            // 创建字节流缓冲区对象
            baos = new ByteArrayOutputStream();

            // 创建单个字节保存变量
            int ch;
            // 读取字节流并保存
            while (-1 != (ch = is.read())){
                baos.write(ch);
            }

            // 将缓冲区中内容写入字节数组
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }finally  {
            // 关闭输入输出流
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    // 重写父类findClass方法，类加载器会自动调用
    @Override protected Class<?> findClass(String className) {
        System.out.println("className:" + className );
        System.out.println("classLoaderName:" + this.classLoaderName);
        byte[] data = this.loadClassData(className);
        return this.defineClass(className, data, 0, data.length);
    }

    /*
    Main
     */
    public static void main(String[] args) throws Exception {
        // 创建加载器实例
        TestCreateClassLoader loader1 = new TestCreateClassLoader("loader1");
        loader1.setPath("/Users/space/Documents/Growth/Package/Note/UnderstandingTheJVM/Practice/createClass/");

        // 获取加载后的Class对象
        Class<?> clazz = loader1.loadClass("ClassLoader.TestClass1");
        System.out.println(clazz);
        // 原newInstance方法已过时
        Object object = clazz.getDeclaredConstructor().newInstance();
        System.out.println(object);
    }
}

