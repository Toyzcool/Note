package Six;

class Dog {
    void bark(int age,String name){
        System.out.println(age+":"+name);
    }
    void bark(String name,int age){
        System.out.println(name+":"+age);
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark(30, "CK");
        dog.bark("Koo",50);
    }
}
