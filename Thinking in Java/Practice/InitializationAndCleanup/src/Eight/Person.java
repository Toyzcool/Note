package Eight;

class Person {
    // 获取苹果
    public void eat(Apple apple){
        Apple peeled = apple.getPeeled();
        System.out.println("Cool");
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.eat(new Apple());
    }
}
