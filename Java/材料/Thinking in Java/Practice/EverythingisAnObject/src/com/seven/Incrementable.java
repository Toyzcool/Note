package com.seven;

public class Incrementable {
    static void increment(){
        StaticTest.i++;
    }

    public static void main(String[] args) {
        Incrementable.increment();
        int res = StaticTest.i;
        System.out.println(res);
    }
}
