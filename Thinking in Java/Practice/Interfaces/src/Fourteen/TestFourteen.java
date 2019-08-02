package Fourteen;

public class TestFourteen {
    static void test1(CanJump canJump){
        canJump.jump();
    }
    static void test2(CanRun canRun){
        canRun.fastRun();
    }
    static void test3(CanSay canSay){
        canSay.fastSay();
    }
    static void test4(Human human){
        human.CanSleep();
    }

    public static void main(String[] args) {
        test1(new Son());
        test2(new Son());
        test3(new Son());
        test4(new Son());
    }

}
