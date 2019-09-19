package nine;

public class TestR {
    public static void main(String[] args) {
        RodentGenerator generator = new RodentGenerator();
        Rodent[] r = new Rodent[9];
        for (int i = 0 ; i < r.length ; i++) {
            r[i] = generator.generate();
        }
        for (Rodent rt : r) {
            rt.run();
        }
    }
}
