package seventeen;

import static util.Print.*;

public class Book {
    Book(String s){
        print("Initial");
        print(s);
    }

    public static void main(String[] args) {
        Book[] books = new Book[10];
        Book book = new Book("Yes");
    }
}
