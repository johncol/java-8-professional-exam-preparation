package java8professional.chapter06.assertions;

public class AssertionClass2 {
    static void ensureGreaterThanZero(int code) {
        System.out.println("Input code: " + code);
        assert code > 0 : "Code isn't greater than 0";
    }
}
