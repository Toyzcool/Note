package com.seven;

import static util.Print.*;

public class ShortCircuit {
    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        int k = 3;
        print("res:"+((i<2)&&(j<2)&&(k<2)));
    }
}
