package Four.TestFactoryMethod;

public class ProductFatory {
    public static Product getProduct(String s){
        switch (s){
            default:return null;
            case "a" :return new Product1();
            case "b" :return new Product2();
            case "c" :return new Product3();
        }
    }
}
