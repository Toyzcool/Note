package TestPoly;

class TestPoly {
    public static void main(String[] args) {
        Father father = new Son();
        //  1.成员函数
        father.method1();
        father.method2();
        //  father.method3();  // 编译失败

        //  2.成员变量
        Father father1 = new Father();
        System.out.println(father.num);
        System.out.println(father1.num);


        //  3.静态成员
        father.method4();
        father1.method4();
    }
}
