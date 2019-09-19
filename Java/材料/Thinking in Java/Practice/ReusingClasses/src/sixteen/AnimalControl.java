package sixteen;

public class AnimalControl {
    public void tech(Amphibian amphibian){
        amphibian.b();
    }

    public static void main(String[] args) {
        Frog frog = new Frog();
        AnimalControl animalControl = new AnimalControl();
        // tech可接受Amphibian的子类
        animalControl.tech(frog);
    }
}
