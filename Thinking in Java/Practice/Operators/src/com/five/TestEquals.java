package com.five;

public class TestEquals {
    public static void main(String[] args) {
        // 使用==比较 相同内容的不同对象
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        System.out.print("使用==比较 相同内容的不同对象:");
        System.out.println(n1 == n2);

        // 使用equals比较 相同内容的不同对象
        System.out.print("使用equals比较 相同内容的不同对象:");
        System.out.println(n1.equals(n2));

    }
}
