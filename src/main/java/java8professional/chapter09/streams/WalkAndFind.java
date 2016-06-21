package java8professional.chapter09.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.FileVisitOption.*;

public class WalkAndFind {

    static List<String> findWithWakMethod(Path path, String ext) {
        try {
            return Files.walk(path, 4, FOLLOW_LINKS)
                    .map(Path::toString)
                    .filter(file -> file.endsWith(ext))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " -> " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    static List<String> findWithFindMethod(Path path, String ext) {
        try {
            return Files.find(path, Integer.MAX_VALUE, (file, attributes) -> file.toString().endsWith(ext))
                    .map(Path::toString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " -> " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Path path = Paths.get("D:\\Videos\\Series\\iZombie");
        String ext = ".mkv";
        System.out.println(MessageFormat.format("Files with extension {0} in path {1}:", ext, path.toAbsolutePath()));
        findWithFindMethod(path, ext).forEach(System.out::println);
    }



}
