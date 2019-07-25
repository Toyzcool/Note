package Two;

public class Circle extends Shape{
    @Override
    protected void draw(){
        System.out.println("Circle is Drawing");
    }
    @Override
    protected void erase(){
        System.out.println("Circle has been erased");
    }
    @Override
    protected void say(){
        System.out.println("Circle wants to say");
    }
}
