package com.four;

import static util.Print.*;

public class TestIncreasing {
    public static void main(String[] args) {
        int i = 1;
        int j = i;
        print("i = "+i);
        // 前缀递增
        j = ++i;
        print("前缀递增后");
        print("i = "+i);
        print("j = "+j);
        i = 1;
        j = i;
        // 前缀递减
        j = --i;
        print("前缀递减后");
        print("i = "+i);
        print("j = "+j);
        i = 1;
        j = i;
        // 后缀递增
        j = i++;
        print("后缀递增后");
        print("i = "+i);
        print("j = "+j);
        i = 1;
        j = i;
        // 后缀递减
        j = i--;
        print("后缀递减后");
        print("i = "+i);
        print("j = "+j);
        i = 1;
        j = i;
    }
}
