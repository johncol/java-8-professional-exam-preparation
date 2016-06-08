package java8professional.chapter06.exceptions;

import java.text.ParseException;

public class TryStatement {

    public static void main(String[] args) throws MyCustomException {
        exceptionsMessage();
    }

    static void exceptionsMessage() throws MyCustomException {
        //throw new MyCustomException();
        //throw new MyCustomException("Custom error message");
        //throw new MyCustomException(new RuntimeException("runtime error message"));
        throw new MyCustomException(new RuntimeException(new Exception("some message")));
    }

    void tries() {
        try {
            // statements
        } catch (RuntimeException e) {
            // statements
        }

        try {
            // statements
        } finally {
            // statements
        }

        try {
            // statements
        } catch (RuntimeException e) {
            // statements
        } finally {
            // statements
        }
    }

    void mayThrow1() throws ParseException {
    }

    void mayThrow2() throws ParseException {
        throw new ParseException("", 0);
    }

    void mayThrow3() {
        try {
            throw new ParseException("", 0);
        } catch (ParseException e) {
            // statements
        }
    }
}

class MyCustomException extends Exception {

    public MyCustomException() {
        super();
    }

    public MyCustomException(Exception exception) {
        super(exception);
    }

    public MyCustomException(String message) {
        super(message);
    }
}