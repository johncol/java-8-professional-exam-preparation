package java8professional.chapter06.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class MultiCatch {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        try {
            Path path = Paths.get("some-file.txt");
            String text = new String(Files.readAllBytes(path));
            LocalDate date = LocalDate.parse(text);
            System.out.println(date);
        } catch (IOException | DateTimeParseException e) {
            e.printStackTrace();
        }
    }

    static void test2() {
        try {
            throw new FileNotFoundException();
        } catch (IOException /*| FileNotFoundException*/ e) { // does not compile because FileNotFoundException extends from IOException
        }
    }

    static void test3() {
        try {
            throw new FileNotFoundException();
        } catch (IOException e) {
            // not advised, but allowed
            e = new FileNotFoundException();
        }
        try {
            throw new FileNotFoundException();
        } catch (IOException | RuntimeException e) {
            // not allowed, will not compile
            // e = new FileNotFoundException();
        }
    }

}
