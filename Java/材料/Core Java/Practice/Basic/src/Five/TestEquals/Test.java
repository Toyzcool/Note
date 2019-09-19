package Five.TestEquals;

import Five.TestEnum.TestEnum;

public class Test {
    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
        System.out.println(father instanceof Son);
        System.out.println(son instanceof Father);
    }
}
