package Test.TestStaticInitialization;

import static util.Print.print;

public class ExplicitStatic {

    public static void main(String[] args) {
        print("Inside Main");
        Cups.cup1.f(99);
    }
}
