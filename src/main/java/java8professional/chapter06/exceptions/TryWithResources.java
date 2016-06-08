package java8professional.chapter06.exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DateTimeException;
import java.util.Scanner;

public class TryWithResources {

    static void copyFilesContent(Path source, Path destination) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(source);
             BufferedWriter out = Files.newBufferedWriter(destination)) {
            out.write(in.readLine());
        }
    }

    static void tryWithResources() {
        try (Scanner scanner = new Scanner(System.in)) {
            // protected code
        } catch (IllegalArgumentException e) {
            // resources declared in the try parenthesis are no longer available
        } catch (StringIndexOutOfBoundsException | DateTimeException e) {
            // resources declared in the try parenthesis are no longer available
        } finally {
            // resources declared in the try parenthesis are no longer available
        }
    }

}
