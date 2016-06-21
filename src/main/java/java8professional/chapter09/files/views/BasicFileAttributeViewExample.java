package java8professional.chapter09.files.views;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributeViewExample {

    public static void main(String[] args) {
        Path path = Paths.get("LICENSE");
        BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        System.out.println("Attributes view: " + view);

        try {
            BasicFileAttributes attributes = view.readAttributes();
            System.out.println("last modified time: " + attributes.lastModifiedTime());

            FileTime newLastModifiedTime = FileTime.fromMillis(System.currentTimeMillis() + 10_000);
            view.setTimes(newLastModifiedTime, null, null);

            attributes = view.readAttributes();
            System.out.println("last modified time: " + attributes.lastModifiedTime());
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " -> " + e.getMessage());
        }
    }

}
