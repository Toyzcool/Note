package Nine.Test;

/*
@Author: Toyz
@Date: 2019-08-12
@Time: 07:59
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDouble {
    private static void printChar(Character characterc){
        System.out.println(characterc);
    }
    public static void main(String[] args) {
        List<Character> list = Arrays.asList('a','b','c');
        // 双冒号用法
        list.forEach(TestDouble::printChar);
        // 普通方法实现
        for (Character c : list) {
            TestDouble.printChar(c);
        }
    }
}
