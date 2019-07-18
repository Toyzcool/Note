package two;

import static util.StaticPrint.*;

public class RandomCompare {
    public static void main(String[] args) {
        int n1 = 0;
        int n2;
        for (int i = 0 ; i < 25; i++){
            n2 = (int) (Math.random()*100);
            if ( n2 > n1 ) {
                print(n1+","+n2);
                print("bigger");
            }else if ( n2 < n1 ){
                print(n1+","+n2);
                print("smaller");
            }else{
                print(n1+","+n2);
                print("equal");
            }
            n1 = n2;
        }
    }
}
