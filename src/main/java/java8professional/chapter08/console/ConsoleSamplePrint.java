package java8professional.chapter08.console;

import java.io.Console;

public class ConsoleSamplePrint {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            throw new RuntimeException("No console!");
        }
        console.writer().println("Welcome to the zoo!");
        console.format("Our zoo has %d animals and employs %d people.", 3910, 325);
        console.writer().println();
        console.printf("Our zoo has %d animals and employs %d people.", 3910, 325);
    }
}
