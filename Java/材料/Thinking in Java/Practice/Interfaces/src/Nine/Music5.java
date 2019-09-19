package Nine;

public class Music5 {
    static void tune(Playable playable){
        playable.play(Note.MIDDLE_C);
    }
    static void tuneAll(Playable[] e){
        for (Playable playable: e
             ) {
            tune(playable);
        }
    }

    public static void main(String[] args) {
        Playable[] orchestra = {
            new Wind(),
            new Percussion(),
            new Stringed(),
            new Brass(),
            new Woodwind(),
        };
        tuneAll(orchestra);
    }
}
