package thirteen;

public class DerivedClass extends BasicClass{
    void f(Double d){
        System.out.println("Double:"+d);
    }

    public static void main(String[] args) {
        DerivedClass derivedClass = new DerivedClass();
        derivedClass.f(1);
        derivedClass.f("String");
        derivedClass.f(2.323);
        derivedClass.f('c');
    }
}
