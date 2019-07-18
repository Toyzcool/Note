package five;

import static util.StaticPrintnb.*;

public class TestForeach {
    public static void main(String[] args) {
        for (char c:"You konw what I mean".toCharArray()
             ) {
            printnb(c+"");
        }
    }
}
