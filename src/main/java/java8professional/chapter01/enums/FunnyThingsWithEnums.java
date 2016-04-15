package java8professional.chapter01.enums;

public class FunnyThingsWithEnums {

    static interface InnerInterface {}

    static void classMethod(SomeInterface someInterface) {
        System.out.println(someInterface);
    }

    public static void main(String[] args) {
        classMethod(SomeEnum.A);
    }

}

interface SomeInterface {
    void anyMethod();
}

enum SomeEnum implements SomeInterface {

    A, B, C;

    private SomeEnum() {}

    public void anyMethod() {

    }

}
