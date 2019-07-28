package Eleven;

public class Upcase extends StringProcessor {
    @Override public String process(Object object) {
        return ((String)object).toUpperCase();
    }
}
