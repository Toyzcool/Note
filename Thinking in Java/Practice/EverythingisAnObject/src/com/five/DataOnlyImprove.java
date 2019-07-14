package com.five;


public class DataOnlyImprove {
        int i;
        double d;
        boolean b;
        void show(){
            System.out.println(i);
            System.out.println(d);
            System.out.println(b);
        }
        public static void main(String[] args) {
            DataOnlyImprove data = new DataOnlyImprove();
            data.i = 4;
            data.d = 5;
            data.b = true;
            data.show();
    }
}
