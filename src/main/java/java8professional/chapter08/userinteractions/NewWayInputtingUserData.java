package java8professional.chapter08.userinteractions;

import java.io.*;

public class NewWayInputtingUserData {

    static final String EXIT_KEYWORD = "exit";

    /**
     * Execute from terminal, or System.console() will return null
     */
    public static void main(String[] args) throws IOException {
        System.out.println("End app writing '" + EXIT_KEYWORD + "'");
        Console console = System.console();
        if (console == null) {
            System.out.println("Terminating app because no console found");
            System.exit(0);
        }

        String input;
        System.out.print("Now, write: ");
        while(!(input = console.readLine()).equalsIgnoreCase(EXIT_KEYWORD)) {
            System.out.println(String.format("Your input: '%s'", input));
            System.out.print("And again: ");
        }
        System.out.println("Bye");
    }

}
