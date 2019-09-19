package Two;

public class Triangle extends Shape{
    @Override
    protected void draw(){
        System.out.println("Triangle is Drawing");
    }
    @Override
    protected void erase(){
        System.out.println("Triangle has been erased");
    }
}
