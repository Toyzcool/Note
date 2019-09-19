package TwentyTwo;

public class Money {
    public enum MoneyValue{
        ONE, FIVE, TEN, TWENTY, FIFTY, HUNDRED;
    }

    public static void main(String[] args) {
        for (MoneyValue mv: MoneyValue.values()
             ) {
            switch (mv){
                case ONE:
                    System.out.println("This is smallest");
                    System.out.println(mv.ordinal());
                    break;
                case FIVE:
                    System.out.println("This is second");
                    break;
                case TEN:
                    System.out.println("This is third");
                    break;
                case TWENTY:
                    System.out.println("This is forth");
                    break;
                case FIFTY:
                    System.out.println("This is fifth");
                    break;
                case HUNDRED:
                    System.out.println("This is largest");
                    break;
            }
        }
    }
}
