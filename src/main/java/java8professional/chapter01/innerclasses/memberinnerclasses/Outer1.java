package java8professional.chapter01.innerclasses.memberinnerclasses;

import static java8professional.util.Utils.*;

public class Outer1 {

    private String name = "Outer";

    public void callInner() {
        Inner1 inner = new Inner1();
        inner.printIt();
    }

    protected class Inner1 {

        // does not compile: static without final keyword
        // private static int repetitions = 2;

        // does not compile: cannot have static methods
        // static final void a () {}

        private static final int repetitions = 2;

        public void printIt() {
            for (int i = 0; i < repetitions; i++) {
                print("Hello " + name);
            }
        }

    }

    public static void main(String[] args) {
        Outer1 outer = new Outer1();
        outer.callInner();
        separator();

        Inner1 inner = outer.new Inner1();
        inner.printIt();
        separator();

    }

}
