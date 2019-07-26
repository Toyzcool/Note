package FiveAnother;

import Five.Machine;

public class Printer implements Machine {

    @Override public void print() {
        System.out.println("Printer print");
    }

    @Override public void heat() {
        System.out.println("Printer heat");
    }

    @Override public void fix() {
        System.out.println("Printer fix");
    }
}
