package com.thirteen;

import static util.Print.*;

public class PrintString {
    public static void main(String[] args) {
        int x = 0 , y = 1 , z = 2;
        String s = "x,y,z";
        System.out.println(s+x+y+z);
        System.out.println(s+(x+y+z));
        System.out.println(x+y+z+s);
        System.out.println(x+""+s);
        System.out.println(""+x);
        System.out.println(x+y+z);
    }
}
