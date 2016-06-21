package java8professional.chapter09.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;

public class PrintingFileContent {

    static final double MIN_PERCENTAGE = 85.0;

    static final Predicate<String> MINIMUM_PERCENTAGE = line -> {
        int length = line.length();
        Double percentage = Double.valueOf(line.substring(length - 6, length - 1));
        return percentage >= MIN_PERCENTAGE;
    };

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src\\main\\java\\java8professional\\responses.txt");
        printLines_readAllLines(path);
        printLines_lines(path);
    }

    /**
     * loads all lines in memory, it's ok with small files, not big ones
     */
    static void printLines_readAllLines(Path path) throws IOException {
        System.out.println("Lines with Files.readAllLines:");
        Files.readAllLines(path)
                .stream()
                .filter(MINIMUM_PERCENTAGE)
                .forEach(line -> System.out.println("   " + line));
        System.out.println();
    }

    /**
     * loads a part of the file lines in memory, the ones being processed as a stream
     */
    static void printLines_lines(Path path) throws IOException {
        System.out.println("Lines with Files.lines:");
        Files.lines(path)
                .filter(MINIMUM_PERCENTAGE)
                .forEach(line -> System.out.println("   " + line));
        System.out.println();
    }

}
