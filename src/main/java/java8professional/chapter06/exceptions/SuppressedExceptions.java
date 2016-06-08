package java8professional.chapter06.exceptions;

import java.util.Arrays;

public class SuppressedExceptions {
    public static void main(String[] args) throws Exception {
        try {
            tryWithResourcesFlowTest();
        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println(" Number of suppressed exceptions: " + e.getSuppressed().length);
        }
    }

    private static void tryWithResourcesFlowTest() throws Exception {
        try(MicrowaveOven m1 = new MicrowaveOven(1);
            MicrowaveOven m2 = new MicrowaveOven(2)) {
            System.out.println("Try block");
            throw new RuntimeException("Exception in try block");
        } catch (RuntimeException | OvenDoorException e) {
            System.out.println(e.getClass().getSimpleName() + " caught: " + e.getMessage());
            System.out.println("suppressed exceptions:");
            Arrays.stream(e.getSuppressed()).forEach(t -> System.out.println(" -> " + t.getMessage()));
            throw e;
        } finally {
            System.out.println("Finally statement");
            throw new Exception("Exception in finally block");
        }
    }
}

class MicrowaveOven implements AutoCloseable {

    private final int code;

    public MicrowaveOven(int code) {
        System.out.println("New microwave oven " + code);
        this.code = code;
    }

    @Override
    public void close() throws OvenDoorException {
        System.out.println("Closing microwave " + code);
        throw new OvenDoorException("Error closing microwave " + code);
    }

}

class OvenDoorException extends Exception {
    public OvenDoorException(String message) {
        super(message);
    }
}