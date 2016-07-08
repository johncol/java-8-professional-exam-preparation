package java8professional.all;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesAndStreamMethods {
    public static void main(String[] args) {
        Path path = Paths.get("./src");

        try {
            Files.walk(path, FileVisitOption.FOLLOW_LINKS)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .filter(f -> !f.contains(".java"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------------------------");

        try {
            Files.find(path, 2, (p, a) -> a.isDirectory())
                    .forEach(System.out::println);
        } catch (IOException e) {}

        System.out.println("-------------------------------------------");

        try {
            Files.list(path).forEach(System.out::println);
        } catch (IOException e) {}

        System.out.println("-------------------------------------------");

        try {
            Files.lines(Paths.get("java8professional.iml")).forEach(System.out::println);
        } catch (IOException e) {}
    }
}
