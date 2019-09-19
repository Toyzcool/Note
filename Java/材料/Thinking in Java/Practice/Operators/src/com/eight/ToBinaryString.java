package com.eight;
import static util.Print.*;

public class ToBinaryString {
    public static void main(String[] args) {
        long n1 = 0xffff;
        long n2 = 023223;
        print(Long.toBinaryString(n1));
        print(Long.toBinaryString(n2));
    }
}
