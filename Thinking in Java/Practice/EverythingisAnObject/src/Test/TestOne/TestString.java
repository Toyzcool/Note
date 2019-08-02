package Test.TestOne;

public class TestString {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "efg";
        System.out.println("s1:"+s1);
        System.out.println("s1的地址为："+s1.hashCode());
        System.out.println("s2:"+s2);
        System.out.println("s2的地址为："+s2.hashCode());
        s1 = s1 + s2;
        System.out.println("new s1:"+s1);
        System.out.println("new s1的地址为："+s1.hashCode());
    }
}
