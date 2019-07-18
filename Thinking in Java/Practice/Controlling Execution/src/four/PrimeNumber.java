package four;

import static util.StaticPrint.*;

public class PrimeNumber {
    public static void main(String[] args) {
        outer:for (int i = 1 ; i < 100 ; i++ ){
            inter:for (int j = 2 ; j < i ; j++ ){
                if ( i%j == 0){
                    continue outer; }
                }
            print(i+"");
        }
    }
}
