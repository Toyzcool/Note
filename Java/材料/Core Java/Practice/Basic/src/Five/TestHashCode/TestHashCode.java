package Five.TestHashCode;

public class TestHashCode {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "a";
        Integer i = 10;
        Integer k = 10;
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1.equals(s2));
        System.out.println(i.hashCode());
        System.out.println(k.hashCode());
        System.out.println(i.equals(k));
    }
}
