package Two;

public class Detergent extends Cleanser {
    // 覆盖方法
    public void protectedPrint(){
        System.out.println("覆盖超类的protectedPrint()");
        super.protectedPrint();
    }

    public void sterilize(){
        System.out.println("子类的新方法");
    }

    public static void main(String[] args) {
        System.out.println("1.覆盖超类的方法");
        Detergent detergent = new Detergent();
        detergent.protectedPrint();
        System.out.println("");
        System.out.println("2.子类的新方法");
        detergent.sterilize();
        System.out.println("");
        System.out.println("3.子类调用超类的方法");
        detergent.publicPrint();
    }
}
