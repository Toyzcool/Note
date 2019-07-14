package com.eight;

public class Incrementable {
    static void increment(){
        StaticTest.i++;
    }

    public static void main(String[] args) {
        // before
        StaticTest st1 = new StaticTest();
        StaticTest st2 = new StaticTest();
        System.out.println("Before");
        System.out.println("st1:"+st1.i);
        System.out.println("st2:"+st2.i);
        // after
        Incrementable.increment();
        System.out.println("After");
        System.out.println("st1:"+st1.i);
        System.out.println("st2:"+st2.i);
        // another
        StaticTest st3 = new StaticTest();
        System.out.println("Another");
        System.out.println("st3:"+st3.i);
    }
}
