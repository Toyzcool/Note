package TestAdapter;

public class TestAdapter {
    public static void main(String[] args) {
        System.out.println("1.使用220V适配器");
        new Phone().charging(new Adapter220V());
        System.out.println("2.使用110V适配器");
        new Phone().charging(new Adapter110V());
    }
}
