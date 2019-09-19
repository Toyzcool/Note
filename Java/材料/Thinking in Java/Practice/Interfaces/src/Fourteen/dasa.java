package Fourteen;

class A {
    private interface D{
        void f();
    };
    private class DImp implements D{
        @Override public void f() {};
    }
    public class DImp2 implements D{
        @Override public void f(){};
    }

}
