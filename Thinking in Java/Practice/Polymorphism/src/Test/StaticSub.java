package Test;

public class StaticSub extends StaticSuper {
    static String staticGet(){
        return "Sub staticGet";
    }
    String dynamicGet(){
        return "Sub dynamicGet";
    }
}
