package com.four;

import java.util.Random;

public class TestRandom {
    public static void main(String[] args) {
        Random random1 = new Random(10);
        Random random2 = new Random(10);
        int i = random1.nextInt();
        int j = random2.nextInt();
        System.out.println("i="+i);
        System.out.println("j="+j);
    }
}
