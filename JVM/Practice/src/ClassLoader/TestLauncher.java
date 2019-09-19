package ClassLoader;

/*
@Author: Toyz
@Date: 2019-08-23
@Time: 12:22
*/



class TestLauncher {
    static {
        System.out.println("TestLauncher static");
    }

    public static void main(String[] args) {
        // System.out.println(TestSub.b);
        // System.out.println("-----------");
        TestSub.doSomething();
    }
}

class TestSuper{
    static int a = 3;
    static {
        System.out.println("Super static");
    }
    static void doSomething(){
        System.out.println("Super doSomething");
    }
}

class TestSub extends TestSuper{
    static int b = 4;
    static {
        System.out.println("Sub static");
    }
}
