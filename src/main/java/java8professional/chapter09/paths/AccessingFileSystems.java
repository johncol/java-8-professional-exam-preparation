package java8professional.chapter09.paths;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;

public class AccessingFileSystems {

    public static void main(String[] args) {
        FileSystem fileSystem = FileSystems.getDefault();
        Path path;

        path = fileSystem.getPath("C:/Program Files/Java/jdk1.8.0_74");
        describePath(path);

        path = fileSystem.getPath("C:\\Program Files\\Java\\jdk1.8.0_74\\");
        describePath(path);

        path = fileSystem.getPath("C:", "Program Files", "Java/jdk1.8.0_74");
        describePath(path);

        try {
            URI uri = new URI("http://www.selikoff.net");
            fileSystem = FileSystems.getFileSystem(uri);
            path = fileSystem.getPath("duck.txt");
            describePath(path);
        } catch (URISyntaxException | ProviderNotFoundException | FileSystemNotFoundException | SecurityException e) {
            System.out.println(e.getClass().getSimpleName() + " -> " + e.getMessage());
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
