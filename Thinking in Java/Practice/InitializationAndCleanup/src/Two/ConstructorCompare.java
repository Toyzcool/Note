package Two;

public class ConstructorCompare {
    String name = "name";
    String buildName;
    ConstructorCompare(){
        buildName = "buildName";
    }

    public static void main(String[] args) {
        ConstructorCompare constructorCompare = new ConstructorCompare();
        System.out.println(constructorCompare.name);
        System.out.println(constructorCompare.buildName);
    }
}
