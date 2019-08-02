package Eighteen;

public class TestEighteen {
    public static void main(String[] args) {
        ServiceImp serviceImp = new ServiceFactoryImp().getService();
        serviceImp.method();
    }
}
