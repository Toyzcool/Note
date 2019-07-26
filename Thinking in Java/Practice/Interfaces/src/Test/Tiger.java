package Test;

public class Tiger extends Animal implements Hunt{
    @Override void run() {
        System.out.println("Tiger Run");
    }

    @Override public void hunt() {
        System.out.println("Tiger Hunt");
    }
}
