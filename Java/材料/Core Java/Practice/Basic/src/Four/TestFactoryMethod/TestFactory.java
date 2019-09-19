package Four.TestFactoryMethod;

public class TestFactory {
    public static void main(String[] args) {
        ProductFatory.getProduct("a").show();
        ProductFatory.getProduct("b").show();
        ProductFatory.getProduct("c").show();
    }
}
