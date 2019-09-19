package com.four;

public class DataOnly {
    int i = 5;
    double d = 4;
    boolean b = true;
    void show(){
        System.out.println(i);
        System.out.println(d);
        System.out.println(b);
    }

    public static void main(String[] args) {
        DataOnly data = new DataOnly();
        System.out.println(data.i);
        System.out.println(data.d);
        System.out.println(data.b);
        data.show();
    }
}
