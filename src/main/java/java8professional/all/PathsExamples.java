package java8professional.all;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static java.nio.file.LinkOption.*;
import static java.nio.file.StandardCopyOption.*;

public class PathsExamples {

    public static void main(String[] args) {
        Path path = Paths.get("a/b/c");
        Path path1 = Paths.get("E:/./data");
        Path path2 = Paths.get("E:/user/home");
        filesMethods2(path, path1, path2);
    }

    static void fileMethods(File file) {
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        boolean isFile = file.isFile();
        File[] files = file.listFiles();
        boolean mkdir = file.mkdir();
        boolean mkdirs = file.mkdirs();
        boolean delete = file.delete();
        boolean renameTo = file.renameTo(new File(""));
        boolean isAbsolute = file.isAbsolute();
        String getName = file.getName();
        String getParent = file.getParent();

        long length = file.length();

        boolean hidden = file.isHidden();

        boolean canRead = file.canRead();
        boolean canExecute = file.canExecute();
        boolean canWrite = file.canWrite();

        long lastModified = file.lastModified();
        boolean setLastModified = file.setLastModified(1L);

    }

    static void pathMethods(Path path1, Path path2) {
        int nameCount = path1.getNameCount();
        Path name = path1.getName(0);
        Path fileName = path1.getFileName();
        Path parent = path1.getParent();
        Path root = path1.getRoot();
        boolean absolute = path1.isAbsolute();
        Path absolutePath = path1.toAbsolutePath();
        Path subpath = path1.subpath(0, 1);
        Path relativize = path1.relativize(path2);
        Path resolve = path1.resolve(path2);
        Path normalize = path1.normalize();
        try {
            Path realPath = path1.toRealPath();
        } catch (IOException e) {}
    }

    static void filesMethods1(Path path1, Path path2) {
        boolean exists = Files.exists(path1);
        try {
            boolean sameFile = Files.isSameFile(path1, path2);
            Path directory = Files.createDirectory(path1);
            Path directories = Files.createDirectories(path1);
            Path copy = Files.copy(path1, path2, NOFOLLOW_LINKS, REPLACE_EXISTING, COPY_ATTRIBUTES);
            Path move = Files.move(path1, path2, NOFOLLOW_LINKS, REPLACE_EXISTING, ATOMIC_MOVE);
            Files.delete(path1);
            boolean deleteIfExists = Files.deleteIfExists(path1);
            BufferedReader bufferedReader = Files.newBufferedReader(path1);
            BufferedWriter bufferedWriter = Files.newBufferedWriter(path1);
            List<String> lines = Files.readAllLines(path1);
        } catch (IOException e) {}
    }

    static void filesMethods2(Path path, Path path1, Path path2) {
        boolean isDirectory = Files.isDirectory(path1);
        boolean isRegularFile = Files.isRegularFile(path1);
        boolean isSymbolicLink = Files.isSymbolicLink(path1);

        try {
            boolean hidden = Files.isHidden(path1);
        } catch (IOException e) {}

        boolean readable = Files.isReadable(path1);
        boolean executable = Files.isExecutable(path1);
        boolean writable = Files.isWritable(path1);

        try {
            long size = Files.size(path1);
        } catch (IOException e) {}

        try {
            FileTime lastModifiedTime = Files.getLastModifiedTime(path1);
        } catch (IOException e) {}

        try {
            Path setLastModifiedTime = Files.setLastModifiedTime(path1, FileTime.fromMillis(System.currentTimeMillis()));
        } catch (IOException e) {}
    }

    static void filesReadAttributes(Path path) {
        BasicFileAttributes basicFileAttributes;
        try {
            basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
        } catch (IOException e) { throw new RuntimeException(e); }

        boolean isDirectory = basicFileAttributes.isDirectory();
        boolean isRegularFile = basicFileAttributes.isRegularFile();
        boolean isSymbolicLink = basicFileAttributes.isSymbolicLink();
        boolean isOther = basicFileAttributes.isOther();

        long size = basicFileAttributes.size();

        FileTime lastModifiedTime = basicFileAttributes.lastModifiedTime();
        FileTime lastAccessTime = basicFileAttributes.lastAccessTime();
        FileTime creationTime = basicFileAttributes.creationTime();

        Object fileKey = basicFileAttributes.fileKey();
    }

    static void filesGetFileAttributeView(Path path) {
        BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);

        try {
            BasicFileAttributes basicFileAttributes = fileAttributeView.readAttributes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String name = fileAttributeView.name();

        FileTime lastModifiedTime = null;
        FileTime lastAccessedTime = null;
        FileTime creationTime = null;

        try {
            fileAttributeView.setTimes(lastModifiedTime, lastAccessedTime, creationTime);
        } catch (IOException e) {}

    }
}
