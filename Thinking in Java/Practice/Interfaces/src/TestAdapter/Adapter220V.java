package TestAdapter;

public class Adapter220V extends Adaptee220V implements Target {
    @Override public int output5V() {
        int v = super.output220V();
        int dst = v / 44;
        return dst;
    }
}
