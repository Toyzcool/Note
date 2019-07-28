package TestAdapter;

public class Adapter220V extends Adaptee220V implements Target {
    @Override public void output5V() {
        super.output220V();
        System.out.println("220V转换成了5V");
    }
}
