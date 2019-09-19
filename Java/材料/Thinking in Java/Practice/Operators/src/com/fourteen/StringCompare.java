package com.fourteen;

public class StringCompare {
    static void f(boolean b){
        if (b == true){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
    static void stringTest(String s1,String s2){
        f(s1 == s2);
        f(s1 != s2);
        f(s1.equals(s2));
    }
    public static void main(String[] args) {
        // 定义需要比较的字符串
        String s1 = "one" , s2 = "one";
        // 调用字符串比较方法
        stringTest(s1,s2);
    }
}
