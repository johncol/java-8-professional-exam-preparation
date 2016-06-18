package java8professional.chapter08.console;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;

public class ConsoleReadInputSample {
    public static void main(String[] args) throws IOException {
        Console console = System.console();
        if (console == null) {
            throw new RuntimeException("No console!");
        }

        console.writer().print("How excited are you about your trip today? ");
        console.flush();
        String excitementAnswer = console.readLine();
        String name = console.readLine("Please enter your name: ");

        BufferedReader bufferedReader = new BufferedReader(console.reader());
        String value = bufferedReader.readLine();
        int age = Integer.valueOf(value);

        console.writer().println();
        console.format("Your name is %s", name);
        console.writer().println();
        console.format("Your age is %d", age);
        console.format("Your excitement level is %s", excitementAnswer);

    }
}
