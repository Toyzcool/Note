package TestAdapter;

public class Adapter110V extends Adaptee110V implements Target {
    @Override public void output5V() {
        super.output110V();
        System.out.println("110V转换成了5V");
    }
}
