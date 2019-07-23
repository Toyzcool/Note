package Three;

public class ConstructorThree {
    ConstructorThree(){
        System.out.println("This is default constructor");
    }
    ConstructorThree(String name){
        System.out.println("This is constructor with paramter:"+name);
    }

    public static void main(String[] args) {
        ConstructorThree constructorThree = new ConstructorThree();
        ConstructorThree constructorThree1 = new ConstructorThree("Toyz");
    }
}
