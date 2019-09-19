package com.ten;

public class ToBinary {
    public static void main(String[] args) {
        int n1 = 0x0015;
        int n2 = 0x002a;
        System.out.println(Long.toBinaryString(n1&n2));
        System.out.println(Long.toBinaryString(n1|n2));
        System.out.println(Long.toBinaryString(n1^n2));
        System.out.println(Long.toBinaryString(~n1));
        System.out.println(Long.toBinaryString(~n2));
    }
}
