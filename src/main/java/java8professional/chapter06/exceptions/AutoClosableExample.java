package java8professional.chapter06.exceptions;

import java.util.Arrays;

public class AutoClosableExample {
    public static void main(String[] args) {
        try (RefrigeratorResource r = new RefrigeratorResource()) {
            r.takeOrange();
            throw new RefrigeratorException("There are no more oranges");
        } catch (RefrigeratorException e) {
            System.out.println(e.getMessage());
            System.out.println("--------- suppressed exceptions");
            Arrays.stream(e.getSuppressed()).forEach(t -> System.out.println(t.getMessage()));
            System.out.println("--------- suppressed exceptions");
        } finally {
            System.out.println("No more food!");
        }
    }
}

class RefrigeratorResource implements AutoCloseable {
    @Override
    public void close() throws RefrigeratorException {
        System.out.println("Refrigerator is now being closed..");
        throw new RefrigeratorException("Refrigerator broke when closing!");
    }
    void takeOrange() {
        System.out.println("Orange taken from refrigerator");
    }
}

class RefrigeratorException extends Exception {
    public RefrigeratorException(String message) {
        super(message);
    }
}