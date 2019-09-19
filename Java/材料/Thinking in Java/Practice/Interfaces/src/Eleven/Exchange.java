package Eleven;

public class Exchange {

    public String process(String s) {
        char[] ca = new char[s.length()];
        if (ca.length % 2 == 0) {
            for (int i = 0 ; i < s.length() ; i += 2) {
                ca[i] = s.charAt(i + 1);
                ca[i + 1] = s.charAt(i);
            }
            return new String(ca);
        } else {
            for (int i = 0 ; i < s.length() - 1 ; i += 2) {
                ca[i] = s.charAt(i + 1);
                ca[i + 1] = s.charAt(i);
            }
            ca[s.length() - 1] = s.charAt(s.length() - 1);
            return new String(ca);
        }
    }
}
