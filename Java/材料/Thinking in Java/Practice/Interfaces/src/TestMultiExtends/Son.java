package TestMultiExtends;

public class Son extends Father implements Human {

    @Override public void say() {
        System.out.println("Son say");
    }
}
