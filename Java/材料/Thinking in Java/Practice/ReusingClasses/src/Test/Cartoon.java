package Test;

public class Cartoon extends Drawing {
        Cartoon(int i){
            System.out.println("Cartoon Constructor:"+i);
        }
    public static void main(String[] args) {
        Cartoon cartoon = new Cartoon(11);
    }
}
