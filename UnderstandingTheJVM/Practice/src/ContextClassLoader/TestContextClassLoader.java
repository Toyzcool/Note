package ContextClassLoader;

/*
@Author: Toyz
@Date: 2019/8/31
@Time: 12:05
@Purpose:
@Related:
*/


public class TestContextClassLoader implements Runnable {
    Thread thread;

    public TestContextClassLoader() {
        // 初始化线程，并在当前类创建对象时开始线程
        thread = new Thread(this);
        thread.start();
    }

    @Override public void run() {
        // 获取加载当前线程的加载器
        ClassLoader classLoader = this.thread.getContextClassLoader();
        // 将加载当前线程的加载器设置为获取到的加载器，当前代码没有意义
        this.thread.setContextClassLoader(classLoader);
        System.out.println("Class:"+classLoader.getClass());
        System.out.println("Parent:"+classLoader.getParent().getClass());
    }

    public static void main(String[] args) {
        new TestContextClassLoader();
    }
}
