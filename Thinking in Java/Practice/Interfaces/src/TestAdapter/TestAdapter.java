package TestAdapter;

public class TestAdapter {
    public static void main(String[] args) {
        new Phone().charging(new Adapter220V());
        new Phone().charging(new Adapter110V());
    }
}
