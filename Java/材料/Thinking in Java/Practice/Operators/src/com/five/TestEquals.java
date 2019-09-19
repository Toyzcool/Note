package com.five;

public class TestEquals {
    public static void main(String[] args) {
        // 使用==比较 基本数据类的相同内容的不同对象
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        System.out.print("使用==比较 相同内容的不同对象:");
        System.out.println(n1 == n2);

        // 使用equals比较 基本数据类的相同内容的不同对象
        System.out.print("使用equals比较 相同内容的不同对象:");
        System.out.println(n1.equals(n2));

        // 使用==比较 自定义类的相同内容的不同对象
        Dog dog1 = new Dog();
        dog1.setName("spot");
        dog1.setSays("Ruff!");
        Dog dog2 = new Dog();
        dog2.setName("spot");
        dog2.setSays("Ruff!");
        System.out.print("使用==比较 自定义类的相同内容的不同对象:");
        System.out.println(dog1 == dog2);

        // 使用equals比较 自定义类的相同内容的不同对象
        System.out.print("使用equals比较 相同内容的不同对象:");
        System.out.println(dog1.equals(dog2));
    }
}
