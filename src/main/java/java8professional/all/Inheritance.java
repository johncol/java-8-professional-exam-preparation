package java8professional.all;

public class Inheritance {}

class One {}
class Two extends One {}

class ExceptionOne extends Exception {}
class ExceptionTwo extends ExceptionOne {}

class Parent {
    protected One method(One param) throws ExceptionOne {
        return new One();
    }
}

class Child extends Parent {
    @Override
    public Two method(One param) throws ExceptionTwo {
        return new Two();
    }
}