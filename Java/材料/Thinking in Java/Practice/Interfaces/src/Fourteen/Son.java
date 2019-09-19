package Fourteen;

public class Son extends Father implements Human {
    @Override public void CanSleep() {
        System.out.println("Son CanSleep");
    }

    @Override public void jump() {
        System.out.println("Son jump");
    }

    @Override public void fastJump() {
        System.out.println("Son fastJump");
    }

    @Override public void run() {
        System.out.println("Son run");
    }

    @Override public void fastRun() {
        System.out.println("Son fastRun");
    }

    @Override public void say() {
        System.out.println("Son say");
    }

    @Override public void fastSay() {
        System.out.println("Son fastSay");
    }
}
