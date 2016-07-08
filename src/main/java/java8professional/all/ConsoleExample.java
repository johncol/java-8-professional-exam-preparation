package java8professional.all;

import java.io.Console;
import java.io.File;
import java.io.PrintWriter;
import java.io.Reader;

public class ConsoleExample {
    public static void main(String[] args) {
        Console console = System.console();

        console.printf("");
        console.format("");

        String s1 = console.readLine();
        String s2 = console.readLine("");
        char[] c1 = console.readPassword();
        char[] c2 = console.readPassword("");

        PrintWriter writer = console.writer();
        Reader reader = console.reader();

        writer.printf("");
        writer.print("");
        writer.println();
        writer.format("");
        writer.write("");

    }
}
