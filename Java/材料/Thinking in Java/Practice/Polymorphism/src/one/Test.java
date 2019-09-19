package one;

public class Test {
    static void ride(Cycle cycle){
        System.out.println(cycle.name);
    }

    public static void main(String[] args) {
        Cycle cycle = new Tricycle();
        ride(cycle);
    }
}
