package Four;

public class TestFour {
    static void TestDrive(Vehicle vehicle){
        ((Car)vehicle).drive();
    }

    static void TestSecondDrive(SecondVehicle secondVehicle){
        secondVehicle.drive();
    }

    public static void main(String[] args) {
        TestDrive(new Car());
        TestSecondDrive(new SecondCar());
        SecondVehicle secondCar = new SecondCar();
        secondCar.fix();

    }
}
