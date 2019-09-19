package nine;

import java.util.Random;

public class RodentGenerator {
    Random random = new Random(47);
    Rodent generate(){
        switch (random.nextInt(3)){
            default:
            case 0:
                return new Mouse();
            case 1:
                return new Hamster();
            case 2:
                return new Gerbil();
        }
    }
}
