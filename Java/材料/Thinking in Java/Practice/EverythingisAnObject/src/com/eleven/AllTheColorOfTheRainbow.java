package com.eleven;

public class AllTheColorOfTheRainbow {
    int anIntegerRepresentinColors;
    void changeTheHueOfTheColor(int newHue){
        anIntegerRepresentinColors = newHue;
        System.out.println(anIntegerRepresentinColors);
    }
    public static void main(String[] args) {
        AllTheColorOfTheRainbow acr = new AllTheColorOfTheRainbow();
        int before = acr.anIntegerRepresentinColors = 10;
        System.out.println("before:"+before);
        System.out.print("after:");
        acr.changeTheHueOfTheColor(60);
    }
}
