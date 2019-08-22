package ClassLoader;

/*
@Author: Toyz
@Date: 2019-08-22
@Time: 09:38
*/


public class TestArray {
    public static void main(String[] args) {
        SubTest subTest = new SubTest();
        System.out.println("subTest.getClass():"+subTest.getClass());
        System.out.println("=============");
        SubTest[] subTests = new SubTest[1];
        System.out.println("subTests.getClass():"+subTests.getClass());
        System.out.println("subTests.getClass().getSuperclass():"+subTests.getClass().getSuperclass());
        System.out.println("=============");
        SubTest[][] subTestsMulti = new SubTest[1][1];
        System.out.println("subTestsMulti.getClass():"+subTestsMulti.getClass());
        System.out.println("subTestsMulti.getClass().getSuperclass():"+subTestsMulti.getClass().getSuperclass());
    }
}
class SubTest{
    static {
        System.out.println("SubTest Build");
    }
}
