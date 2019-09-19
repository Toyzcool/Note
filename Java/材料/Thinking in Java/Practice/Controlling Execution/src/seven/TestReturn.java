package seven;

public class TestReturn {
    public static void main(String[] args) {
        for(;;){
            for (;;){
                for (int i = 0 ; i < 100 ; i++ ){
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}
