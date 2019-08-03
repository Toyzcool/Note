package Four.TestConstructor;

public class TestCons {
    private int age = 4;

    {
        age = 5;
    }

    private TestCons() {
        this.age = 6;
    }

    public static void main(String[] args) {
        TestCons testCons = new TestCons();
        System.out.println(testCons.age);
    }
}
