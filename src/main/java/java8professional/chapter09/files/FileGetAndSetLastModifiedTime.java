package java8professional.chapter09.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

public class FileGetAndSetLastModifiedTime {

    public static void main(String[] args) {
        Path path = Paths.get("java8professional.iml");
        System.out.println("Path: " + path.toAbsolutePath());

        try {
            FileTime lastModifiedTime = Files.getLastModifiedTime(path);
            System.out.println("Last modified time:                    " + lastModifiedTime);

            Thread.sleep(1000);
            Files.setLastModifiedTime(path, FileTime.fromMillis(System.currentTimeMillis()));

            lastModifiedTime = Files.getLastModifiedTime(path);
            System.out.println("Last modified after modification time: " + lastModifiedTime);
        } catch (IOException e) {
            System.out.println("IOException! " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("InterruptedException! " + e.getMessage());
        }
    }

}
