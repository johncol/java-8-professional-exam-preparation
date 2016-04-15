package java8professional.chapter01.innerclasses.localinnerclasses;

import static java8professional.util.Utils.*;

public class Outer {

    private String instanceFieldMessage = "This is an instance variable from the outer class";

    private void printField() {
        print(instanceFieldMessage);
    }

    public void someMethod(final String finalArgument, String effectivelyFinalArgument) {

        final String finalMessage = "This is a final local variable";

        String effectivelyFinalMessage = "This is an effectively final local variable";

        String nonFinalMessage = "First message value";
        nonFinalMessage = "Second message value";

        class InnerLocalClass {

            public static final String someConstant = "";

            private String someField = "";

            public void callOuterClassMethod() {
                printField();
            }

            public void printOuterClassInstanceField() {
                print(instanceFieldMessage);
            }

            public void printFinalLocalVariable() {
                print(finalMessage);
            }

            public void printEffectivelyFinalLocalVariable() {
                print(effectivelyFinalMessage);
            }

            public void printNonFinalLocalVariable() {
                // does not compile: variable used here is not final nor effectively final
                // print(nonFinalMessage);
            }

            public void printFinalArgument() {
                print(finalArgument);
            }

            public void printEffectivelyFinalArgument() {
                print(effectivelyFinalArgument);
            }

        }

        InnerLocalClass innerLocalClass = new InnerLocalClass();

        innerLocalClass.callOuterClassMethod();
        innerLocalClass.printOuterClassInstanceField();
        innerLocalClass.printFinalLocalVariable();
        innerLocalClass.printEffectivelyFinalLocalVariable();
        innerLocalClass.printNonFinalLocalVariable();
        innerLocalClass.printFinalArgument();
        innerLocalClass.printEffectivelyFinalArgument();
    }

    public static void main(String[] args) {
        new Outer().someMethod("Final argument message", "Effectively final argument message");
    }

}

