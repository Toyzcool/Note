package com.seven;
import static util.Print.*;

import java.util.Random;

public class Coin {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt();
        if ( i%2 == 0 ){
            print("正面");
        }else {
            print("反面");
        }
    }
}
