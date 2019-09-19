package Five.TestEnum;

public class TestEnum {
     public enum Size{
        MAX("max",3),MIN("min",1),MEDIUM("medium",2);
        // 成员变量
        private String name;
        private int num;
        // 成员变量的构造方法
        Size(String name , int i) {
            this.name = name;
            this.num = i;
        }
    }
    public static void main(String[] args) {
        // 在同一个类中，因此可以访问私有的成员变量name
        String name = Size.MAX.name;
        System.out.println(name);
    }
}
