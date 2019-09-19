package Five;

class Dog {
    void bark(String voice){
        System.out.println(voice);
    }
    void bark(char voice){
        System.out.println("howling");
    }
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark("barking");
        dog.bark('v');
    }
}
