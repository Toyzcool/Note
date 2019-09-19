package com.six;

public class Storage {
    int storage(String s){
        return s.length()*2;
    }
    public static void main(String[] args) {
        String string = new String("xyz");
        Storage storage = new Storage();
        int StrLength = storage.storage(string);
        System.out.println(StrLength);
    }
}
