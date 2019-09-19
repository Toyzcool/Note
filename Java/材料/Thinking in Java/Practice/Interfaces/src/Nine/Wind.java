package Nine;

import static util.Print.*;

public class Wind implements Instrument,Playable {

    @Override public void play(Note n) {
        print(this+".play()"+n);
    }

    @Override public void adjust() {
        print(this+".adjust()");
    }

    @Override public String toString() {
        return "Wind";
    }
}
