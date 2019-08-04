package Five.TestToString;

public class TestToString {
    String name = "asd";

    @Override public String toString() {
        return "TestToString{" + "name='" + name + '\'' + '}';
    }

    public static void main(String[] args) {
        TestToString testToString = new TestToString();
        System.out.println(testToString+"jkl");
        System.out.println(testToString.getClass());
    }
}
