package java8professional.chapter09.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;

public class FileProperties {

    public static void main(String[] args) {
        printFileProperties(Paths.get("src"));
        printFileProperties(Paths.get("src\\main\\java\\java8professional\\responses.txt"));
        printFileProperties(Paths.get("does-not-exist"));
    }

    private static void printFileProperties(Path path) {
        System.out.println("Path: " + path.toAbsolutePath());
        System.out.println("-----------------------------------------------");

        boolean directory = Files.isDirectory(path);
        System.out.println("  Is directory:       " + directory);

        boolean regularFile = Files.isRegularFile(path);
        System.out.println("  Is file:            " + regularFile);

        boolean symbolicLink = Files.isSymbolicLink(path);
        System.out.println("  Is symbolic link:   " + symbolicLink);

        boolean readable = Files.isReadable(path);
        System.out.println("  Is readable:        " + readable);

        boolean executable = Files.isExecutable(path);
        System.out.println("  Is executable:      " + executable);

        try {
            boolean hidden = Files.isHidden(path);
            System.out.println("  Is hidden:          " + hidden);
        } catch (IOException e) {
            handleException(e, "Files.isHidden");
        }

        try {
            long size = Files.size(path);
            System.out.println("  Size(bytes):        " + size);
        } catch (IOException e) {
            handleException(e, "Files.size");
        }

        try {
            FileTime lastModifiedTime = Files.getLastModifiedTime(path);
            System.out.println("  Last Modified Time: " + lastModifiedTime);
        } catch (IOException e) {
            handleException(e, "Files.getLastModifiedTime");
        }

        try {
            UserPrincipal owner = Files.getOwner(path);
            System.out.println("  Owner:              " + owner);
        } catch (IOException e) {
            handleException(e, "Files.getOwner");
        }

        System.out.println();
    }

    static void handleException(IOException e, String method) {
        System.out.println("  " + method + " -> " + e.getClass().getSimpleName() + " -> " + e.getMessage());
    }

}
