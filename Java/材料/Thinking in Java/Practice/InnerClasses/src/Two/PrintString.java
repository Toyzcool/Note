package Two;

class PrintString {
    String s;

    PrintString(String s) {
        this.s = s;
    }

    @Override public String toString() {
        return "PrintString{" + "s='" + s + '\'' + '}';
    }

    public static void main(String[] args) {
        PrintString ps1 = new PrintString("ps1");
        PrintString ps2 = new PrintString("ps2");
        PrintString ps3 = new PrintString("ps3");
        Sequence s = new Sequence(3);
        s.add(ps1);
        s.add(ps2);
        s.add(ps3);
        Selector selector = s.selector();
        while (!selector.end()){
            System.out.println(selector.current());
            selector.next();
        }
    }
}
