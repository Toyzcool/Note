package Test;

public class TestTest {
    public static void main(String[] args) {
        Animal animal = new Tiger();
        animal.run();
        ((Tiger) animal).hunt();
    }
}
