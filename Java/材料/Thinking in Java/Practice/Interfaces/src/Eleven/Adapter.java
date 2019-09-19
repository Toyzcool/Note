package Eleven;

public class Adapter implements Processor {
    Exchange exchange;
    @Override public String name() {
        return getClass().getSimpleName();
    }

    @Override public Object process(Object object) {
        return exchange.process((String) object);
    }
}
