package Eleven;

public abstract class StringProcessor implements Processor {
    @Override public String name() {
        return getClass().getSimpleName();
    }
    // 抽象方法，因为继承这个类的导出类需要重写这个方法，满足具体的需求
    @Override public abstract Object process(Object object);

    public static String s = "end the war";

    public static void main(String[] args) {
        Apply.process(new Upcase(),s);
        Apply.process(new Adapter(),s);
    }
}
