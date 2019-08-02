package TestAdapter;

public class Adapter110V extends Adaptee110V implements Target {
    @Override public int output5V() {
        int v = super.output110V();
        int dst = v / 22;
        return dst;
    }
}
