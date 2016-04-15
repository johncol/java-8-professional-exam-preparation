package java8professional.chapter01.innerclasses.anonymousinnerclass;

import static java8professional.util.Utils.*;

interface Runnable {}

public class Outer {

    private String instanceVariable = "instanceVariable";

    private Runnable runnable = new Runnable() {};

    private Stoppable stoppable = new Stoppable() {
        @Override
        public void stop() {
            print(instanceVariable);
        }
    };

    private void stop(Stoppable stoppable) {
        stoppable.stop();
    }

    public static void main(String[] args) {

        Outer outer = new Outer();

        Stoppable localStoppable = new Stoppable() {
            @Override
            public void stop() {
                print("Anonymous class instance saved in a variable");
            }
        };
        outer.stop(localStoppable);

        outer.stop(new Stoppable() {
            @Override
            public void stop() {
                print("Anonymous class instance passed to a method right away");
            }
        });

        outer.stop(() -> print("Lambda expression replacing one method interface anonymous implementation"));

        final String localFinalVariable = "localFinalVariable";
        outer.stop(new Stoppable() {
            @Override
            public void stop() {
                print(localFinalVariable);
            }
        });

        String localEffectivelyFinalVariable = "localEffectivelyFinalVariable";
        outer.stop(new Stoppable() {
            @Override
            public void stop() {
                print(localEffectivelyFinalVariable);
            }
        });

        outer.stop(outer.stoppable);

    }

}


interface Stoppable {
    void stop();
}
