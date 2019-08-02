package TestReusingClass;

public class TestReusingClass {
    public static void main(String[] args) {
        Father father = new Father();
        Father fatherToSon = new Son();
        Son son = new Son();

        System.out.println(father.num);
        System.out.println(fatherToSon.num);
        System.out.println(son.num);

        father.show();
        fatherToSon.show();
        son.show();
    }
}
