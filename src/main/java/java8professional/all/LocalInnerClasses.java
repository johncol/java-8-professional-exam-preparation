package java8professional.all;

public class LocalInnerClasses {
}

class Outer2 {

    private String hi = "HI!!!!";

    public Object method(String hi3) {

        String hi2 = "hi?";

        abstract class LocalInner {
            private static final String SOME = "some?";
            abstract void hi();
        }

        class LocalInner2 extends LocalInner {
            void hi() {
                System.out.println(hi + "-" + hi2 + "-" + hi3);
            }
        }

        LocalInner localInner = new LocalInner2();
        return localInner;
    }

}
