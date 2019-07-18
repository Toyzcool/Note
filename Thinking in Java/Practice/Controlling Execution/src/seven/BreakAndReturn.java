package seven;

public class BreakAndReturn {
    static void Count1(int num){
        for (int i = 1 ; i <= num ; i++ ){
            System.out.println(i);
            if (i == 99) break;
        }
    }
    static void Count2(int num){
        for (int i = 1 ; i <= num ; i++ ){
            System.out.println(i);
            if (i == 99) return;
        }
    }
    public static void main(String[] args) {
       // Count1(100);
       Count2(100);
    }
}
