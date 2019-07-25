package Test.Static;

import static util.Print.*;

public class TestS {
    public static void main(String[] args) {
        StaticSuper staticSuper = new StaticSub();
        print(staticSuper.dynamicGet());
        print(staticSuper.staticGet());
    }
}
