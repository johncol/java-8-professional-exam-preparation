package java8professional.chapter09.paths;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingPaths {

    public static void main(String[] args) {
        Path path;

        path = Paths.get("C:/Program Files/Java/jdk1.8.0_74");
        describePath(path);

        path = Paths.get("C:\\Program Files\\Java\\jdk1.8.0_74\\");
        describePath(path);

        path = Paths.get("C:", "Program Files", "Java/jdk1.8.0_74");
        describePath(path);

        try {
            URI uri = new URI("file:///C:/Program%20Files/Java/jdk1.8.0_74");
            path = Paths.get(uri);
            describePath(path);
        } catch (URISyntaxException e) {
            System.out.println("URISyntaxException -> " + e.getMessage());
        }
    }

    static void describePath(Path path) {
        System.out.println("Path:       " + path);
        System.out.println("URI:        " + path.toUri());
        System.out.println("Normalized: " + path.normalize());
        System.out.println("Exists:     " + path.toFile().exists());
        System.out.println();
    }
}
