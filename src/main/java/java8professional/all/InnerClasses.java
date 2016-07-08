package java8professional.all;

public class InnerClasses {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
    }
}

class Outer {

    private String id = "Outer";

    protected class Inner {

        static final String LOL = "LOL";

        private String id = "Inner";

        public Inner() {
            System.out.println("ID1: " + Outer.this.id);
            System.out.println("ID2: " + this.id);
        }
    }

}
