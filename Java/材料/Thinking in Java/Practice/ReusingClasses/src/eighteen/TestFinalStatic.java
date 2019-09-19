package eighteen;

import java.util.Random;

public class TestFinalStatic {
    static Random random = new Random(20);
    // final static 的恒定初始值
    final static int a = random.nextInt(20);
    // final 常量
    final int b = random.nextInt(20);

    public static void main(String[] args) {
        TestFinalStatic testFinalStatic = new TestFinalStatic();
        System.out.println("对象1");
        System.out.println("b:"+testFinalStatic.b);
        System.out.println("a:"+a);
        System.out.println("");
        System.out.println("对象2");
        TestFinalStatic testFinalStatic2 = new TestFinalStatic();
        System.out.println("b:"+testFinalStatic2.b);
        System.out.println("a:"+a);
    }
}
