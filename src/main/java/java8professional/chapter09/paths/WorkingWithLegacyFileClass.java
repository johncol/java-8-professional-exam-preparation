package java8professional.chapter09.paths;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WorkingWithLegacyFileClass {
    public static void main(String[] args) {
        File file;
        Path path;

        file = new File("C:/Program Files/Java/jdk1.8.0_74");
        path = file.toPath();
        System.out.println("File: " + file);
        System.out.println("Path: " + path);

        System.out.println();

        path = Paths.get("C:/Program Files/Java/jdk1.8.0_74");
        file = path.toFile();
        System.out.println("File: " + file);
        System.out.println("Path: " + path);
    }
}
