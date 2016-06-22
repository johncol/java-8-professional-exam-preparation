package java8professional.chapter09;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ChapterTest {

    public static void main(String[] args) throws URISyntaxException {

        Path path = Paths.get(".").normalize();
        System.out.println("Path: " + path);
        System.out.println("Path count: " + path.getNameCount());
        System.out.println("name 0: '" + path.getName(0) + "'");
    }


}
