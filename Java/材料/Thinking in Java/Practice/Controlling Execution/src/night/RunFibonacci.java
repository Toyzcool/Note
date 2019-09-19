package night;

public class RunFibonacci {
    static void Fibonacci(int n){
        int i = 0;
        int sum = 1;
        int preInt1 =0;
        do{
            System.out.println(sum);
            sum = sum + preInt1;
            preInt1 = sum - preInt1;
            i++;
        }
        while ( i < n);
    }
    public static void main(String[] args) {
        Fibonacci(10);
    }
}
