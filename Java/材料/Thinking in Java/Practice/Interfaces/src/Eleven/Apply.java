package Eleven;

public class Apply {
    public static void process(Processor processor,String s){
        System.out.println("Use Process"+processor.name());
        System.out.println(processor.process(s));
    }
}
