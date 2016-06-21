package java8professional.chapter09.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListChildren {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");
        System.out.println("Files in path " + path.normalize().toAbsolutePath() + ":");
        Files.list(path)
                .map(Path::toAbsolutePath)
                .map(Path::normalize)
                .forEach(file -> System.out.println("  " + file));
    }
}
