package ClassLoader;

/*
@Author: Toyz
@Date: 2019-08-22
@Time: 11:44
*/


public class TestPreparation {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        System.out.println("counter1:"+Singleton.counter1);
        System.out.println("counter2:"+Singleton.counter2);
    }
}
class Singleton{
    static int counter1 = 1;
    private static Singleton singleton = new Singleton();

    private Singleton(){
        counter1++;
        counter2++;
    }

    static int counter2 = 0;
    static Singleton getSingleton(){
        return singleton;
    }
}
