package night;

public class FibonacciArray {
    static void Fib(int i){
        int[] arr = new int[i];
        arr[0] = 1;
        arr[1] = 1;
        for (int j = 0 ; j < arr.length ; j++){
            if ( j > 1 ){
                arr[j] = (arr[j-2]+arr[j-1]);
            }
                System.out.println(arr[j]);
        }
    }
    public static void main(String[] args) {
        Fib(10);
    }
}
