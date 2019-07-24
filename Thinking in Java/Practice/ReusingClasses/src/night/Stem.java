package night;

public class Stem extends Root {
    Component1 component1Stem;
    Component2 component2Stem;
    Component3 component3Stem;

    public Stem(int i) {
        super(i);
        System.out.println("Stem:"+i);
    }

    public static void main(String[] args) {
        Stem stem = new Stem(10);
    }

}
