package five;

public class ToBinaryString {
    static void binaryPrint(int q){
        if (q == 0)
            System.out.println(q);
        else{
            int nlz = Integer.numberOfLeadingZeros(q);
            q <<= nlz;
            for (int i = 0 ; i < 32-nlz ; i++ ){
                int n = Integer.numberOfLeadingZeros(q) == 0 ? 1 : 0;
                System.out.print(n);
                q <<= 1;
            }
            System.out.println("");
        }
    }


    public static void main(String[] args) {
        int n1 = 0x15;
        int n2 = 0x2a;
        System.out.println(Integer.toBinaryString(n1));
        System.out.println(Integer.toBinaryString(n2));
        System.out.println(Integer.toBinaryString(n1&n2));
        System.out.println(Integer.toBinaryString(n1|n2));
        System.out.println(Integer.toBinaryString(n1^n2));
        System.out.println(Integer.toBinaryString(~n1));
        System.out.println(Integer.toBinaryString(~n2));

        binaryPrint(n1);
        binaryPrint(n2);
        binaryPrint(n1&n2);
        binaryPrint(n1|n2);
        binaryPrint(n1^n2);
        binaryPrint(~n1);
        binaryPrint(~n2);

    }
}
