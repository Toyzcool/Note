package TestAnonymousInnerClass;

public class Outer {

    void method(){
        new Abs(){

            @Override void show() {
                System.out.println("show");
            }
        }.show();

    }
    enum D{
        X,M,S
    }
    public static void main(String[] args) {
        new Outer().method();
        System.out.println(D.X);
    }
}
