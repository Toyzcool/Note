package Test;

public class TestOverride {
    void f1(int f){
        System.out.println(getType(f));
        System.out.println(f);
    }
    // void f1(double f){
    //     System.out.println(getType(f));
    //     System.out.println(f);
    // }
    public static String getType(Object object){
        String typeName=object.getClass().getName();
        int length= typeName.lastIndexOf(".");
        String type =typeName.substring(length+1);
        return type;
    }

    public static void main(String[] args) {
        TestOverride testOverride = new TestOverride();
        testOverride.f1(100);
        testOverride.f1((int) 3000.08);
    }
}
