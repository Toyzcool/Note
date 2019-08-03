package Three.Two;

import java.io.*;
import java.util.Scanner;

public class TestPrintWriter {
    public static void main(String[] args) throws IOException {
        File file = new File("file/abc.txt");
        Scanner in = new Scanner(file,"UTF-8");
        while (in.hasNextLine()){
            System.out.println(in.nextLine());
        }
        in.close();
        PrintWriter pw = new PrintWriter(file,"UTF-8");
        pw.println("new line3");
        pw.close();
    }
}
