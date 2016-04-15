package java8professional.chapter01.innerclasses.staticinnerclasses;

import static java8professional.util.Utils.*;

public class Outer {

    private String name = "Outer";

    void printInner() {
        print(Inner.uppercaseName);
        print(Inner.LOWERCASE_NAME);
        print(Inner.getLowercaseName());
    }

    public static class Inner {

        private static String uppercaseName = "INNER";
        private static final String LOWERCASE_NAME = "inner";

        public static String getLowercaseName() {
            return LOWERCASE_NAME;
        }

        private String name = "Inner";

        Inner() {
            Outer outer = new Outer();
            print(outer.name);
            outer.printInner();
        }

    }

    public static void main(String[] args) {
        Inner inner = new Inner();
    }

}
