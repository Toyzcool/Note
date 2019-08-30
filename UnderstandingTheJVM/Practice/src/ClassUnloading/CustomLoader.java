package ClassUnloading;

/*
@Author: Toyz
@Date: 2019/8/27
@Time: 15:29
@Purpose:模拟由用户自定义类加载加载的类被卸载
@Related:TestClass.java
*/


import java.io.*;

public class CustomLoader extends ClassLoader{
    /*
    1.创建自定义类加载器
     */
    // 1.1 变量
    private String classLoaderName; //存储加载器名称
    private String path; //存储类文件路径
    private final String fileExtension = ".class"; //文件后缀名

    // 1.2 类加载器的构造方法
    public CustomLoader(String classLoaderName){
        super();
        this.classLoaderName = classLoaderName;
    }

    // 1.3 设置类文件路径方法
    public void setPath(String path) {
        this.path = path;
    }

    // 1.4 读取class文件数据并返回字节码数组的方法
    private byte[] loadClassData(String className){
        // 1.4.1 定义变量
        InputStream is = null; //文件输入流
        byte[] data = null; //返回的字节码数组
        ByteArrayOutputStream baos = null; //存储字节的缓冲区

        // 1.4.2 获取文件输入流并赋值
        className = className.replace(".", "/"); //将类名中的符号修改为路径

        try {
            is = new FileInputStream(new File(this.path+className+this.fileExtension)); //获取文件输入流
            int ch; //存储字节
            baos = new ByteArrayOutputStream(); //创建字节缓冲区对象
            while (-1 != (ch = is.read())){
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    // 1.5 重写父加载器的方法，用来查找class的方法
    @Override protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("ClassLoader:"+this.classLoaderName);
        System.out.println("ClassName:"+name);
        byte[] data = this.loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    /*
    2.测试自定义加载器并卸载类
     */
    public static void main(String[] args) throws Exception {
        // 2.1 创建加载器实例并加载类
        CustomLoader loader = new CustomLoader("customizeLoader");
        loader.setPath("/Users/space/Documents/Growth/Package/Note/UnderstandingTheJVM/Practice/createClass/");
        Class<?> clazz = loader.loadClass("ClassUnloading.TestClass");
        System.out.println(clazz);
        Object object = clazz.getDeclaredConstructor().newInstance();
        System.out.println(object);

        // 2.2 卸载类
        loader = null;  //将加载器引用置空
        clazz = null;   //将class引用置空
        object = null;  //将Object对象引用置空
        Thread.sleep(5000);
        System.out.println("=============调用垃圾回收");
        System.gc();    //调用垃圾回收器
        System.out.println("=============测试置空情况");
        // 2.3 测试置空情况
        System.out.println(loader);
        System.out.println(clazz);
        System.out.println(object);
    }
}
