package fourteen;

import static util.Print.*;

public class Car {
    // 两个静态字符串域，一个在定义处初始化，另一个在静态块中初始化
    static String string1 = "defInBegin";
    static String string2;
    static {
        string2 = "defInStatic";
        print("显式的静态初始化");
    }
    static void printMed(){
        print(string1);
        print(string2);
    }
    Car(){
        print("Car()");
    }

    public static void main(String[] args) {
        new Car();
    }
}
