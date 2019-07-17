package one;
import static util.StaticPrint.*;
public class TestIteration {
    static boolean condition(){
        boolean res = Math.random() < 0.99 ;
        print(res+"");
        return res;
    }
    public static void main(String[] args) {
        while (condition()){
            print("inside");
        }
        print("exite");
    }
}
