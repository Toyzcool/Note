package Four.TestMethodParam;

public class TestMethodParam {
    public static void main(String[] args) {
        int n = 5;
        Method method = new Method();
        System.out.println(n);
        method.changeNum(n);
        System.out.println(n);
    }
}
