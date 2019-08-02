package Test;

public class Test2 {
    static class Inner implements Inter{

        @Override public void method() {
            System.out.println("method");
        }
    }

    static Inter function(){
        return new Inner();
    }

}
