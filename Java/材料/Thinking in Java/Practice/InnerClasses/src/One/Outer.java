package One;

class Outer {
    private String string;

    Outer(String string) {
        this.string = string;
    }

    class Inner{
        Inner() {
            System.out.println("Inner Construct Successful");
        }
        void printString(){
            System.out.println(string);
        }
    }
    Inner getInner(){
        return new Inner();
    }

    public static void main(String[] args) {
        Outer.Inner inner = new Outer("KKK").getInner();
        inner.printString();
    }
}
