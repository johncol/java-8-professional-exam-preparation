package java8professional.chapter06.assertions;

public class DummyAssertion {

    public static void main(String[] args) {
        int numOfGuests = -1;
        assert numOfGuests > 0 : "Number of guests must be greater than 0";
        System.out.println("Number of guests " + numOfGuests);
    }

    /**
     * assertions are disabled by default
     * to enable them:
     *  -> java -enableassertions
     *  -> java -ea
     * to disable them:
     *  -> java -disableassertions
     *  -> java -da
     * to enable in a class or package (-ea or -enableassertions):
     *  -> java -ea:com.some.package.ClassName
     *  -> java -ea:com.some.package...
     * combine:
     *  -> java -ea:java8professional.chapter06.assertions... -da:java8professional.chapter06.assertions.DummyAssertion
     */

}
