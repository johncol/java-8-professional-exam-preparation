package java8professional.chapter06.assertions;

public class AssertionClass1 {

    public static void main(String[] args) {
        int code = -2;
        ensureGreaterOrEqualThanZero(code);
        AssertionClass2.ensureGreaterThanZero(code);
    }

    private static void ensureGreaterOrEqualThanZero(int code) {
        System.out.println("Sending code: " + code);
        assert code >= 0 : "Code isn't greater or equal than 0";
    }

    //-ea:java8professional.chapter06.assertions... -da:java8professional.chapter06.assertions.AssertionClass2
}
