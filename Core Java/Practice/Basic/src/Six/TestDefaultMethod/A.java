package Six.TestDefaultMethod;

public interface A {
    void f();
    default void printInt(){
        System.out.println(111);
    }
}
