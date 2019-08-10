package Five.TestChangeable;

public class TestFindMax {
    static void findMax(Object ... args){
        double largest = Double.NEGATIVE_INFINITY;
        for (Object y: args
             ) {
                Double z = (Double) y;
                if (z > largest) {
                    largest = z;
                }
        }
        System.out.println(largest);
    }

    public static void main(String[] args) {
        TestFindMax.findMax(3.454,34.3);
    }
}
