package java8professional.chapter09.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;

public class FileGetAndSetOwner {

    public static void main(String[] args) {
        Path path = Paths.get("java8professional.iml");
        System.out.println("Path: " + path.toAbsolutePath());

        try {
            UserPrincipal owner = Files.getOwner(path);
            System.out.println("Owner: " + owner);

            UserPrincipal john = path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("john1");
            System.out.println("UserPrincipal john: " + john);

            Files.setOwner(path, john);
            owner = Files.getOwner(path);
            System.out.println("Owner: " + owner);
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " -> " + e.getMessage());
        }
    }

}
