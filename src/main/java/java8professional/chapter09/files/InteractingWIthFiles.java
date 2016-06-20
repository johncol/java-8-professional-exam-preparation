package java8professional.chapter09.files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class InteractingWIthFiles {

    public static void main(String[] args) {

        deleteAllInFolder(Paths.get("./tests/"));
        createDirectory("./tests/");
        separator();

        checkIfFileExists("src/main/java/java8professional");
        checkIfFileExists("src/main/does-not-exist");
        separator();

        checkIsSameFile("src/main", "src/main/java/.././.");
        checkIsSameFile("src/main", "src/main/java");
        checkIsSameFile("does-not-exist", "does-not-exist");
        checkIsSameFile("src/main", "does-not-exist");
        separator();

        createDirectory("tests/test-directory-FIRST");
        createDirectory("tests/directory-that-does-not-exist-FIRST/new-directory");
        separator();

        createDirectories("tests/test-directory-SECOND");
        createDirectories("tests/directory-that-does-not-exist-SECOND/new-directory");
        separator();

        copyFile("tests/test-directory-FIRST", "tests/test-directory-COPY");
        copyFile("does-not-exist", "other-directory-name");
        separator();

        createDirectory("tests/directory1");
        copyFileToStream("tests/directory1", "tests/directory1-COPY-2");
        copyFileToStream("does-not-exist", "tests/test-directory-COPY-2");
        separator();

        copyFileFromStream("tests/test-directory-FIRST", "tests/test-directory-COPY-3");
        copyFileFromStream("src/main/does-not-exist", "tests/test-directory-COPY-3");
        separator();

        moveFile("tests/test-directory-FIRST", "tests/test-directory-FIRST/test-directory-NEW-FIRST");
        moveFile("tests/directory-that-does-not-exist-SECOND", "tests/directory-that-does-not-exist-NEW-SECOND");
        separator();

        deleteFile("tests/does-not-exist");
        deleteFile("tests/test-directory-FIRST");
        deleteFileIfExists("tests/directory-that-does-not-exist-SECOND");
        separator();

        deleteFileIfExists("tests/does-not-exist");
        deleteFileIfExists("tests/test-directory-SECOND");
        deleteFileIfExists("tests/directory-that-does-not-exist-SECOND");
        separator();
    }

    static void checkIfFileExists(String name) {
        Path path = Paths.get(name);
        System.out.println("Exists: " + Files.exists(path));
    }

    static void checkIsSameFile(String name1, String name2) {
        Path path1 = Paths.get(name1);
        Path path2 = Paths.get(name2);
        System.out.print("Paths are the same: ");
        try {
            System.out.println(Files.isSameFile(path1, path2));
        } catch (IOException e) {
            handle(e);
        }
    }

    static void createDirectory(String name) {
        Path path = Paths.get(name);
        try {
            Path directory = Files.createDirectory(path);
            System.out.println("Created directory: " + directory);
        } catch (IOException e) {
            handle(e);
        }
    }

    static void createDirectories(String name) {
        Path path = Paths.get(name);
        try {
            Path directory = Files.createDirectories(path);
            System.out.println("Created directories: " + directory);
        } catch (IOException e) {
            handle(e);
        }
    }

    static void copyFile(String name1, String name2) {
        Path origin = Paths.get(name1);
        Path target = Paths.get(name2);
        try {
            Path copy = Files.copy(origin, target, REPLACE_EXISTING, COPY_ATTRIBUTES, NOFOLLOW_LINKS);
            System.out.println("Copy: " + copy);
        } catch (IOException e) {
            handle(e);
        }
    }

    static void copyFileToStream(String name1, String name2) {
        Path origin = Paths.get(name1);
        try (OutputStream target = new BufferedOutputStream(new FileOutputStream(name2))) {
            long result = Files.copy(origin, target);
            System.out.println("Copy to stream result: " + result);
        } catch (IOException e) {
            handle(e);
        }
    }

    static void copyFileFromStream(String name1, String name2) {
        Path target = Paths.get(name2);
        try (InputStream origin = new BufferedInputStream(new FileInputStream(name1))) {
            long result = Files.copy(origin, target, REPLACE_EXISTING, COPY_ATTRIBUTES, NOFOLLOW_LINKS);
            System.out.println("Copy from stream result: " + result);
        } catch (IOException e) {
            handle(e);
        }
    }

    static void moveFile(String name1, String name2) {
        Path path = Paths.get(name1);
        Path newPath = Paths.get(name2);
        try {
            Path result = Files.move(path, newPath, NOFOLLOW_LINKS, REPLACE_EXISTING, ATOMIC_MOVE);
            System.out.println("Move file result: " + result);
        } catch (IOException e) {
            handle(e);
        }
    }

    static void deleteFile(String name) {
        Path path = Paths.get(name);
        try {
            Files.delete(path);
        } catch (IOException e) {
            handle(e);
        }
    }

    static void deleteFileIfExists(String name) {
        Path path = Paths.get(name);
        try {
            boolean deleted = Files.deleteIfExists(path);
            System.out.println("File deleted: " + deleted);
        } catch (IOException e) {
            handle(e);
        }
    }

    static void deleteAllInFolder(Path path) {
        try {
            Files.list(path).sorted().forEach(InteractingWIthFiles::deleteAllInFolder);
            Files.delete(path);
        } catch (IOException e) {
            handle(e);
        }
    }

    static void separator() {
        System.out.println("------------------------------------");
        System.out.println();
    }

    static void handle(Exception e) {
        System.out.println(e.getClass().getSimpleName() + " -> " + e.getMessage());
    }

}
