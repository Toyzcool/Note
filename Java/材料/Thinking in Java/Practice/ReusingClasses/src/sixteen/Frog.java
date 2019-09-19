package sixteen;
// 子类
public class Frog extends Amphibian{
    public void b(){
        System.out.println("son b");
    }
    public static void main(String[] args) {
        // 向上转型，将父类引用指向子类对象
        Frog frog = new Frog();
        Amphibian amphibian = frog;
        // 调用方法，该方法为子类中的方法
        amphibian.b();
    }
}
