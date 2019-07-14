package com.night;

public class BasicClass {
    public static void main(String[] args) {
        // 当前创建一个基本类型的char引用，会自动包装成包装器类型
        char c = 'x';
        Character ch = new Character('c');
        Character ch2 = new Character('x');
        System.out.println("c:"+c);
        System.out.println("ch:"+ch);
        System.out.println("ch2:"+ch2);
        Character ch3 = 'x';
        char c3 = ch3;
        System.out.println("ch3:"+ch3);
        System.out.println("c3:"+c3);
    }
}
