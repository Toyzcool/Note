package com.eleven;
import static util.Print.*;

public class MoveToRight {
    public static void main(String[] args) {
        int n = 0x10000;
        for (int i = 0; n > 0 ; i++){
            n >>= 1;
            print(Long.toBinaryString(n));
        }
    }
}
