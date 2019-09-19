package Nine;

import static util.Print.print;

public class Percussion implements Instrument,Playable {

    @Override public void play(Note n) {
        print(this+".play()"+n);
    }

    @Override public void adjust() {
        print(this+".adjust()");
    }

    @Override public String toString() {
        return "Percussion";
    }
}
