package SixThree;

import SixOne.Ex6Interface;
import SixTwo.Ex6Base;

public class Ex6 extends Ex6Base {
    Ex6Interface getEx6Inner(){
        return this.new Ex6Inner();
    }

    public static void main(String[] args) {
        Ex6 ex6 = new Ex6();
        Ex6Interface ex6Interface = ex6.getEx6Inner();
        System.out.println(ex6Interface.say());
    }
}
