package Test;

public class TestObjectArray {
    static void printArray(Object[] args){
        for (Object s : args){
            System.out.println(s);
        }
    }
    static void f(int... args){
        System.out.println(args.length);
    }

    public static void main(String[] args) {
        printArray(new Object[]{
            new Integer(35),new Double(23.34),new String("dsaf")
        });
        f(2,4,6,4);
    }
}
