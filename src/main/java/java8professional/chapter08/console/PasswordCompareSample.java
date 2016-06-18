package java8professional.chapter08.console;

import java.io.Console;
import java.util.Arrays;

public class PasswordCompareSample {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            throw new RuntimeException("No console!");
        }

        // request input passwords
        char[] password1 = console.readPassword("Enter your password: ");
        char[] password2 = console.readPassword("Verify your password: ");
        boolean match = Arrays.equals(password1, password2);

        // clear passwords
        Arrays.fill(password1, 'x');
        Arrays.fill(password2, 'x');

        // result
        console.writer().println("Your password " + (match ? "matched" : "did not match"));
    }
}
